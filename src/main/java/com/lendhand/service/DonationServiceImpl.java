package com.lendhand.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lendhand.model.DonationsTable;
import com.lendhand.model.Drive;
import com.lendhand.repository.DonationRepository;

@Service
public class DonationServiceImpl implements DonationService {

    @Autowired
    DonationRepository donationRepository;

    @Autowired
    DriveService driveService;

    @Override
    public List<DonationsTable> getAllDonations() {
        return donationRepository.findAll();
    }

    @Override
    public DonationsTable addDonations(DonationsTable DonationsTable) {

        DonationsTable donation = donationRepository.save(DonationsTable);

        // once user has donated updating the donor count in respective drive

        int driveId = donation.getDriveId();

        Drive drive = driveService.getDriveById(String.valueOf(driveId));
        drive.setDonorCount(drive.getDonorCount() + 1);
        driveService.upadateDrive(drive);
        return donation;
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
