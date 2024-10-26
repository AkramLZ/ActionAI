package com.akraml.actionai;

import com.akraml.actionai.actions.OpenWebsiteAction;
import com.akraml.actionai.actions.RunOsCommandAction;
import com.akraml.actionai.actions.TextAction;
import gg.makera.ai.llm.groq.GroqClient;
import gg.makera.ai.llm.groq.GroqModel;

public class Main {

    private static final String GROQ_API_KEY = System.getenv("GROQ_API_KEY");

    public static void main(String[] args) {
        GroqClient client = new GroqClient(GroqModel.LLAMA_3_2_9B, GROQ_API_KEY);

        ActionAI actionAI = new ActionAI();
        actionAI.registerActions(
                new TextAction(),
                new OpenWebsiteAction(),
                new RunOsCommandAction()
        );
        actionAI.startListener(client);

    }

}