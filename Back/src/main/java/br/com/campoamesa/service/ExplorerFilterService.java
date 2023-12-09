package br.com.campoamesa.service;

import br.com.campoamesa.model.UserId;
import br.com.campoamesa.repository.ExplorerFilterRepository;
import br.com.campoamesa.repository.UserIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExplorerFilterService {


    @Autowired
    private ExplorerFilterRepository explorerFilterRepository;

    public List<UserId> findUserIdsByServedCitiesExcludingUser(List<String> cities, String excludeUserId) {
        if (cities == null || cities.isEmpty()) {
            return explorerFilterRepository.findByIdNot(excludeUserId);
        } else {
            return explorerFilterRepository.findUserIdsByServedCitiesExcludingUser(cities, excludeUserId);
        }
    }
}
