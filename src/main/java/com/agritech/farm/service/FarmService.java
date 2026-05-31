package com.agritech.farm.service;

import com.agritech.farm.entity.Crop;
import com.agritech.farm.entity.Greenhouse;
import com.agritech.farm.repository.CropRepository;
import com.agritech.farm.repository.GreenhouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FarmService {


    @Autowired
    private GreenhouseRepository greenhouseRepository;

    @Autowired
    private CropRepository cropRepository;


    public List<Greenhouse> getAllGreenhouses() {
        return greenhouseRepository.findAll();
    }

    public void saveGreenhouse(Greenhouse greenhouse) {
        greenhouseRepository.save(greenhouse);
    }


    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }

    public void saveCrop(Crop crop) {
        cropRepository.save(crop);
    }

    public void deleteCrop(Long id) {
        cropRepository.deleteById(id);
    }
}