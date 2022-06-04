package com.lendhand.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lendhand.model.DonationsTable;
import com.lendhand.repository.DonationRepository;

@Service
public class DonationServiceImpl implements DonationService {

    @Autowired
    DonationRepository donationRepository;

    @Override
    public List<DonationsTable> getAllDonations() {
        return donationRepository.findAll();
    }

    @Override
    public DonationsTable addDonations(DonationsTable DonationsTable) {
        System.out.println("Donation is :" + DonationsTable);
        return donationRepository.save(DonationsTable);
    }

    @Override
    public DonationsTable updateDonations(DonationsTable DonationsTable) {
        return donationRepository.save(DonationsTable);
    }

    @Override
    public DonationsTable getDonationById(String id) {
        return donationRepository.findById(Long.parseLong(id)).get();
    }

    @Override
    public List<DonationsTable> getDonationByUserId(String id) {
        List<DonationsTable> allDonations = getAllDonations();
        List<DonationsTable> currentUserDonation = new ArrayList<DonationsTable>();
        for (DonationsTable DonationsTable : allDonations) {
            if (DonationsTable.getDonorId() == Long.parseLong(id)) {
                currentUserDonation.add(DonationsTable);
            }
        }
        return currentUserDonation;
    }

}
