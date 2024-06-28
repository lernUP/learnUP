package ch.learntrack.backend.backoffice.user

import ch.learntrack.backend.backoffice.BACKOFFICE_ROOT_URL
import ch.learntrack.backend.persistence.UserRole
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("$BACKOFFICE_ROOT_URL/user")
public class UserResource(private val userService: UserService) {
    @GetMapping
    public fun getAllAdminUsers(): List<UserDto> = userService.getAllAdminUsers()

    @PostMapping("/create")
    public fun createAdminUser(@RequestBody createUserDto: CreateUserDto): Unit =
        userService.createAdminUser(createUserDto)

    @GetMapping("/getAllAdminsForSchool")
    public fun getAllAdminsForSchool(@RequestParam schoolId: UUID): List<UserDto> = userService.getAllAdminsForSchool(schoolId)

    //please someone who is smarter than me (me=Shay) fix this
    @GetMapping("/getTeacherCounts")
    public fun getTeacherCounts(@RequestParam schoolId: UUID): Int = userService.getUserCount(schoolId, UserRole.TEACHER)

    @GetMapping("/getStudentCounts")
    public fun getStudentCounts(@RequestParam schoolId: UUID): Int = userService.getUserCount(schoolId, UserRole.STUDENT)
}