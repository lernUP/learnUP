/*
 * This file is generated by jOOQ.
 */
package ch.learnup.backend.persistence.tables.pojos


import java.io.Serializable
import java.time.LocalDateTime
import java.util.UUID


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class Grade(
    val id: UUID,
    val name: String,
    val schoolId: UUID,
    val created: LocalDateTime? = null,
    val updated: LocalDateTime? = null
): Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (other == null)
            return false
        if (this::class != other::class)
            return false
        val o: Grade = other as Grade
        if (this.id != o.id)
            return false
        if (this.name != o.name)
            return false
        if (this.schoolId != o.schoolId)
            return false
        if (this.created == null) {
            if (o.created != null)
                return false
        }
        else if (this.created != o.created)
            return false
        if (this.updated == null) {
            if (o.updated != null)
                return false
        }
        else if (this.updated != o.updated)
            return false
        return true
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + this.id.hashCode()
        result = prime * result + this.name.hashCode()
        result = prime * result + this.schoolId.hashCode()
        result = prime * result + (if (this.created == null) 0 else this.created.hashCode())
        result = prime * result + (if (this.updated == null) 0 else this.updated.hashCode())
        return result
    }

    override fun toString(): String {
        val sb = StringBuilder("Grade (")

        sb.append(id)
        sb.append(", ").append(name)
        sb.append(", ").append(schoolId)
        sb.append(", ").append(created)
        sb.append(", ").append(updated)

        sb.append(")")
        return sb.toString()
    }
}