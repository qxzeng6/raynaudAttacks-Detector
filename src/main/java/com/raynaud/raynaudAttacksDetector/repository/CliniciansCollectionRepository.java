package com.raynaud.raynaudAttacksDetector.repository;

import com.raynaud.raynaudAttacksDetector.model.Paticipants;

import java.util.ArrayList;
import java.util.List;

public class UserCollectionRespository {
    private final List<Paticipants> paticipantsList = new ArrayList<>();

    public UserCollectionRespository() {

    }

    public List<Paticipants> getUserCollection() {
        return paticipantsList;
    }

    public void save(Paticipants paticipants) {
        paticipantsList.add(paticipants);
    }
}
