package com.dirtiestcontext.dice_api.respositories

import com.dirtiestcontext.dice_api.enums.Die
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DieRepository extends CrudRepository<Die, Long>{

}