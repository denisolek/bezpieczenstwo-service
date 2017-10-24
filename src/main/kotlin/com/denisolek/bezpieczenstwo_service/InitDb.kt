package com.denisolek.bezpieczenstwo_service

import com.denisolek.bezpieczenstwo_service.entity.Authority
import com.denisolek.bezpieczenstwo_service.repository.AuthorityRepository
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class InitDb(val authorityRepository: AuthorityRepository) {

    @PostConstruct
    fun init() {
        initAuthority()
    }

    private fun initAuthority() {
        if (authorityRepository.count().toInt() == 0)
            authorityRepository.save(Authority(Authority.Role.ROLE_USER))
    }
}