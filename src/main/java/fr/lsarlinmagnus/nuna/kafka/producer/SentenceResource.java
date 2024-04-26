package fr.lsarlinmagnus.nuna.kafka.producer;

import java.util.UUID;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import fr.lsarlinmagnus.nuna.kafka.model.Sentence;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import io.smallrye.mutiny.Multi;

@Path("/sentence")
public class SentenceResource {

    @Channel("sentence-request")
    Emitter<String> sentenceRequestEmitter;

    @POST
    @Path("/request")
    @Produces(MediaType.TEXT_PLAIN)
    public String createRequest() {
        UUID uuid = UUID.randomUUID();
        sentenceRequestEmitter.send(uuid.toString());
        return uuid.toString();
    }

    @Channel("sentence")
    Multi<Sentence> sentence;

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<Sentence> stream() {
        return sentence;
    }

}
