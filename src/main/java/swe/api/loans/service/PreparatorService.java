package swe.api.loans.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import swe.api.loans.domain.Contract;
import swe.api.loans.domain.Query;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static swe.api.loans.domain.Preparators.pickPreparator;

@Path("/preparator")
@Produces(MediaType.APPLICATION_JSON)
public class PreparatorService {

    private static final Logger LOGGER = LoggerFactory.getLogger("HTTP-Preparator");


    private String preparedBy = pickPreparator();

    private ExecutorService queue = Executors.newSingleThreadExecutor();

    @POST
    public CompletionStage<Contract> process(Query query) {
        return CompletableFuture.supplyAsync(() -> {
            Contract contract = prepare(query);
            LOGGER.info("Query {} for {} is ready to be sent to an approver", query.getQueryId(), query.getCustomerId());
            return contract;
        }, queue);
    }

    Contract prepare(Query query) {
        return new Contract(query, preparedBy);
    }




}
