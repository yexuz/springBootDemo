package com.example.springbootdemo.jpadao;

import com.example.springbootdemo.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, String> {
}
