package com.tgt.epic.service;

import com.tgt.epic.client.RestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EpicHackathonService {

    @Autowired
    private RestClient restClient;

}
