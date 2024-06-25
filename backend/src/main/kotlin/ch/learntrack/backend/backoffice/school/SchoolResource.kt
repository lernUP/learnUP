package ch.learntrack.backend.backoffice.school

import ch.learntrack.backend.backoffice.BACKOFFICE_ROOT_URL
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("$BACKOFFICE_ROOT_URL/school")
public class SchoolResource(private val schoolService: SchoolService) {
    @GetMapping
    public fun getAllSchools(): List<SchoolDto> = schoolService.getAllSchools()

    @PostMapping("/create")
    public fun createSchool(@RequestBody createSchoolDto: CreateSchoolDto): Unit =
        schoolService.createSchool(createSchoolDto)
    @GetMapping("/getAllSchoolsForAdmin")
    public fun getAllSchoolsForAdmin(@RequestParam userId: UUID): List<SchoolDto> = schoolService.getAllSchools()
}
