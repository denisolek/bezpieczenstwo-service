package com.denisolek.bezpieczenstwo_service.repository

import com.denisolek.bezpieczenstwo_service.entity.Authority
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorityRepository : JpaRepository<Authority, Int> {
}