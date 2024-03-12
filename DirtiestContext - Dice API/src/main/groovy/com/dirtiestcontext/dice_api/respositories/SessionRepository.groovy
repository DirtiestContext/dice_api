package com.dirtiestcontext.dice_api.respositories

import com.dirtiestcontext.dice_api.models.Session
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SessionRepository extends CrudRepository<Session, Long>{
}