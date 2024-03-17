package ch.learnup.backend.user

import ch.learnup.backend.persistence.tables.daos.UserDao
import org.springframework.context.support.beans

val userBeans = beans {
    bean<UserRessource>()
    bean<UserDao>()
    bean<UserService>()
}
