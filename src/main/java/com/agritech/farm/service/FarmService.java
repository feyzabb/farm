package com.agritech.farm.service;

import com.agritech.farm.entity.Crop;
import com.agritech.farm.entity.Greenhouse;
import com.agritech.farm.repository.CropRepository;
import com.agritech.farm.repository.GreenhouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FarmService {

    @Autowired
    private GreenhouseRepository greenhouseRepository;

    @Autowired
    private CropRepository cropRepository;

    // --- GREENHOUSE (SERA) METOTLARI ---

    public List<Greenhouse> getAllGreenhouses() {
        return greenhouseRepository.findAll();
    }

    public void saveGreenhouse(Greenhouse greenhouse) {
        greenhouseRepository.save(greenhouse);
    }

    public void deleteGreenhouse(Long id) {
        greenhouseRepository.deleteById(id);
    }

    // Güncelleme işlemi için serayı ID'sine göre bulur
    public Greenhouse getGreenhouseById(Long id) {
        Optional<Greenhouse> optional = greenhouseRepository.findById(id);
        return optional.orElse(null);
    }

    // --- CROP (MAHSUL) METOTLARI ---

    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }

    public void saveCrop(Crop crop) {
        cropRepository.save(crop);
    }

    public void deleteCrop(Long id) {
        cropRepository.deleteById(id);
    }

    // Güncelleme işlemi için mahsulü ID'sine göre bulur
    public Crop getCropById(Long id) {
        Optional<Crop> optional = cropRepository.findById(id);
        return optional.orElse(null);
    }
}