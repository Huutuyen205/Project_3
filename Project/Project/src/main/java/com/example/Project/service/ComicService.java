package com.example.Project.service;
import com.example.Project.entity.Comic;
import com.example.Project.repository.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComicService {
    @Autowired private ComicRepository repo;

    public List<Comic> getAll() { return repo.findAll(); }
    public Comic getById(Long id) { return repo.findById(id).orElse(null); }
    public void save(Comic c) { repo.save(c); }
    public void delete(Long id) { repo.deleteById(id); }
}