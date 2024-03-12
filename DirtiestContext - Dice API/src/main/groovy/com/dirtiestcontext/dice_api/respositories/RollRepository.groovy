package com.dirtiestcontext.dice_api.respositories

import com.dirtiestcontext.dice_api.models.Roll
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RollRepository extends CrudRepository<Roll, Long>{
}