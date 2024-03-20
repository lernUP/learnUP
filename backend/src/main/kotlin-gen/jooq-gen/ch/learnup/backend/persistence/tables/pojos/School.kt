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
public data class School(
    public val id: UUID,
    public val name: String,
    public val address: String,
    public val city: String,
    public val postcode: Int,
    public val created: LocalDateTime? = null,
    public val updated: LocalDateTime? = null
): Serializable {

    public override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (other == null)
            return false
        if (this::class != other::class)
            return false
        val o: School = other as School
        if (this.id != o.id)
            return false
        if (this.name != o.name)
            return false
        if (this.address != o.address)
            return false
        if (this.city != o.city)
            return false
        if (this.postcode != o.postcode)
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

    public override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + this.id.hashCode()
        result = prime * result + this.name.hashCode()
        result = prime * result + this.address.hashCode()
        result = prime * result + this.city.hashCode()
        result = prime * result + this.postcode.hashCode()
        result = prime * result + (if (this.created == null) 0 else this.created.hashCode())
        result = prime * result + (if (this.updated == null) 0 else this.updated.hashCode())
        return result
    }

    public override fun toString(): String {
        val sb = StringBuilder("School (")

        sb.append(id)
        sb.append(", ").append(name)
        sb.append(", ").append(address)
        sb.append(", ").append(city)
        sb.append(", ").append(postcode)
        sb.append(", ").append(created)
        sb.append(", ").append(updated)

        sb.append(")")
        return sb.toString()
    }
}
