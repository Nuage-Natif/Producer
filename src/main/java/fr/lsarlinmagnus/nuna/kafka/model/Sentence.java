package fr.lsarlinmagnus.nuna.kafka.model;

public class Sentence {

    public String id;
    public String content;

    /**
    * Default constructor required for Jackson serializer
    */
    public Sentence() { }

    public Sentence(String id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "id='" + id + '\'' +
                ", content=" + content +
                '}';
    }
}