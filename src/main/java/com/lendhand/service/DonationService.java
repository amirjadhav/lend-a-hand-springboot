package com.lendhand.service;

import java.util.List;

import com.lendhand.model.DonationsTable;

public interface DonationService {

    DonationsTable addDonations(DonationsTable DonationsTable);

    DonationsTable updateDonations(DonationsTable DonationsTable);

    List<DonationsTable> getAllDonations();

    DonationsTable getDonationById(String id);

    List<DonationsTable> getDonationByUserId(String id);

}
