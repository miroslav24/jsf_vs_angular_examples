package com.example.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class MyPhaseListener implements PhaseListener {

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        System.out.println("Phase name:" + event.getPhaseId().getName());
    }

    @Override
    public void afterPhase(PhaseEvent event) {
        // Do your job here which should run right after the RENDER_RESPONSE.
    }

}