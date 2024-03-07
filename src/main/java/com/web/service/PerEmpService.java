package com.web.service;

import com.web.model.PerEmp;
import com.web.repo.PerEmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PerEmpService {

    @Autowired
    private PerEmpRepo perEmpRepository;

    @Autowired
    private FileService fileService;

    public void savePerEmpWithFiles(PerEmp perEmp,
                                    MultipartFile aadharFile, MultipartFile panFile,
                                    MultipartFile passportFile, MultipartFile visaFile,
                                    MultipartFile otherFile) throws IOException {


          PerEmp  savedPerEmp = perEmpRepository.save(perEmp);
        // Save files and update file paths in the PerEmp entity
        if(aadharFile!=null) {
            String aadharFilePath = fileService.saveFile(savedPerEmp.getRegno(), "aadhar", aadharFile);
            savedPerEmp.setAadharFile(aadharFilePath);
        }
        if(panFile!=null) {
            String panFilePath = fileService.saveFile(savedPerEmp.getRegno(), "pan", panFile);
            savedPerEmp.setPanFile(panFilePath);
        } if(passportFile!=null) {
            String passportFilePath = fileService.saveFile(savedPerEmp.getRegno(), "passport", passportFile);
            savedPerEmp.setPassportFile(passportFilePath);
        } if(visaFile!=null) {
            String visaFilePath = fileService.saveFile(savedPerEmp.getRegno(), "visa", visaFile);
            savedPerEmp.setVisaFile(visaFilePath);
        } if(otherFile!=null) {
            String otherFilePath = fileService.saveFile(savedPerEmp.getRegno(), "other", otherFile);
            savedPerEmp.setOtherFile(otherFilePath);
        }
        // Update the PerEmp entity with file paths and save again
        perEmpRepository.save(savedPerEmp);
    }
}
