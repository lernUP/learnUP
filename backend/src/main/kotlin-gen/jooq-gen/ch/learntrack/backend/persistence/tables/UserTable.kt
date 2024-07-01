/*
 * This file is generated by jOOQ.
 */
package ch.learntrack.backend.persistence.tables


import ch.learntrack.backend.persistence.Public
import ch.learntrack.backend.persistence.UserRole
import ch.learntrack.backend.persistence.keys.PK_USER
import ch.learntrack.backend.persistence.keys.T_SUBJECT__FK_SUBJECT_USER
import ch.learntrack.backend.persistence.keys.T_USER_GRADE__FK_USER_GRADE_USER
import ch.learntrack.backend.persistence.keys.T_USER_SCHOOL__FK_USER_SCHOOL_USER
import ch.learntrack.backend.persistence.keys.USER_E_MAIL_ID
import ch.learntrack.backend.persistence.tables.GradeTable.TGradePath
import ch.learntrack.backend.persistence.tables.SchoolTable.TSchoolPath
import ch.learntrack.backend.persistence.tables.SubjectTable.TSubjectPath
import ch.learntrack.backend.persistence.tables.UserGradeTable.TUserGradePath
import ch.learntrack.backend.persistence.tables.UserSchoolTable.TUserSchoolPath
import ch.learntrack.backend.persistence.tables.records.UserRecord

import java.time.LocalDateTime
import java.util.UUID

import kotlin.collections.Collection
import kotlin.collections.List

import org.jooq.Condition
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.InverseForeignKey
import org.jooq.Name
import org.jooq.Path
import org.jooq.PlainSQL
import org.jooq.QueryPart
import org.jooq.Record
import org.jooq.SQL
import org.jooq.Schema
import org.jooq.Select
import org.jooq.Stringly
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.EnumConverter
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
public open class UserTable(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, UserRecord>?,
    parentPath: InverseForeignKey<out Record, UserRecord>?,
    aliased: Table<UserRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<UserRecord>(
    alias,
    Public.PUBLIC,
    path,
    childPath,
    parentPath,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table(),
    where,
) {
    public companion object {

        /**
         * The reference instance of <code>public.t_user</code>
         */
        public val USER: UserTable = UserTable()
    }

    /**
     * The class holding records for this type
     */
    public override fun getRecordType(): Class<UserRecord> = UserRecord::class.java

    /**
     * The column <code>public.t_user.id</code>.
     */
    public val ID: TableField<UserRecord, UUID?> = createField(DSL.name("id"), SQLDataType.UUID.nullable(false), this, "")

    /**
     * The column <code>public.t_user.first_name</code>.
     */
    public val FIRST_NAME: TableField<UserRecord, String?> = createField(DSL.name("first_name"), SQLDataType.VARCHAR.nullable(false), this, "")

    /**
     * The column <code>public.t_user.middle_name</code>.
     */
    public val MIDDLE_NAME: TableField<UserRecord, String?> = createField(DSL.name("middle_name"), SQLDataType.VARCHAR, this, "")

    /**
     * The column <code>public.t_user.last_name</code>.
     */
    public val LAST_NAME: TableField<UserRecord, String?> = createField(DSL.name("last_name"), SQLDataType.VARCHAR.nullable(false), this, "")

    /**
     * The column <code>public.t_user.e_mail</code>.
     */
    public val E_MAIL: TableField<UserRecord, String?> = createField(DSL.name("e_mail"), SQLDataType.VARCHAR.nullable(false), this, "")

    /**
     * The column <code>public.t_user.password</code>.
     */
    public val PASSWORD: TableField<UserRecord, String?> = createField(DSL.name("password"), SQLDataType.VARCHAR.nullable(false), this, "")

    /**
     * The column <code>public.t_user.user_role</code>.
     */
    public val USER_ROLE: TableField<UserRecord, UserRole?> = createField(DSL.name("user_role"), SQLDataType.VARCHAR.nullable(false), this, "", EnumConverter<String, UserRole>(String::class.java, UserRole::class.java))

    /**
     * The column <code>public.t_user.birthdate</code>.
     */
    public val BIRTHDATE: TableField<UserRecord, LocalDateTime?> = createField(DSL.name("birthdate"), SQLDataType.LOCALDATETIME(6), this, "")

    /**
     * The column <code>public.t_user.created</code>.
     */
    public val CREATED: TableField<UserRecord, LocalDateTime?> = createField(DSL.name("created"), SQLDataType.LOCALDATETIME(6), this, "")

    /**
     * The column <code>public.t_user.updated</code>.
     */
    public val UPDATED: TableField<UserRecord, LocalDateTime?> = createField(DSL.name("updated"), SQLDataType.LOCALDATETIME(6), this, "")

    private constructor(alias: Name, aliased: Table<UserRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<UserRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<UserRecord>?, where: Condition): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>public.t_user</code> table reference
     */
    public constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.t_user</code> table reference
     */
    public constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.t_user</code> table reference
     */
    public constructor(): this(DSL.name("t_user"), null)

    public constructor(path: Table<out Record>, childPath: ForeignKey<out Record, UserRecord>?, parentPath: InverseForeignKey<out Record, UserRecord>?): this(Internal.createPathAlias(path, childPath, parentPath), path, childPath, parentPath, USER, null, null)

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public open class TUserPath : UserTable, Path<UserRecord> {
        public constructor(path: Table<out Record>, childPath: ForeignKey<out Record, UserRecord>?, parentPath: InverseForeignKey<out Record, UserRecord>?): super(path, childPath, parentPath)
        private constructor(alias: Name, aliased: Table<UserRecord>): super(alias, aliased)
        public override fun `as`(alias: String): TUserPath = TUserPath(DSL.name(alias), this)
        public override fun `as`(alias: Name): TUserPath = TUserPath(alias, this)
        public override fun `as`(alias: Table<*>): TUserPath = TUserPath(alias.qualifiedName, this)
    }
    public override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    public override fun getPrimaryKey(): UniqueKey<UserRecord> = PK_USER
    public override fun getUniqueKeys(): List<UniqueKey<UserRecord>> = listOf(USER_E_MAIL_ID)

    private lateinit var _tSubject: TSubjectPath

    /**
     * Get the implicit to-many join path to the <code>public.t_subject</code>
     * table
     */
    public fun tSubject(): TSubjectPath {
        if (!this::_tSubject.isInitialized)
            _tSubject = TSubjectPath(this, null, T_SUBJECT__FK_SUBJECT_USER.inverseKey)

        return _tSubject;
    }

    public val tSubject: TSubjectPath
        get(): TSubjectPath = tSubject()

    private lateinit var _tUserGrade: TUserGradePath

    /**
     * Get the implicit to-many join path to the
     * <code>public.t_user_grade</code> table
     */
    public fun tUserGrade(): TUserGradePath {
        if (!this::_tUserGrade.isInitialized)
            _tUserGrade = TUserGradePath(this, null, T_USER_GRADE__FK_USER_GRADE_USER.inverseKey)

        return _tUserGrade;
    }

    public val tUserGrade: TUserGradePath
        get(): TUserGradePath = tUserGrade()

    private lateinit var _tUserSchool: TUserSchoolPath

    /**
     * Get the implicit to-many join path to the
     * <code>public.t_user_school</code> table
     */
    public fun tUserSchool(): TUserSchoolPath {
        if (!this::_tUserSchool.isInitialized)
            _tUserSchool = TUserSchoolPath(this, null, T_USER_SCHOOL__FK_USER_SCHOOL_USER.inverseKey)

        return _tUserSchool;
    }

    public val tUserSchool: TUserSchoolPath
        get(): TUserSchoolPath = tUserSchool()

    /**
     * Get the implicit many-to-many join path to the
     * <code>public.t_grade</code> table
     */
    public val tGrade: TGradePath
        get(): TGradePath = tUserGrade().tGrade()

    /**
     * Get the implicit many-to-many join path to the
     * <code>public.t_school</code> table
     */
    public val tSchool: TSchoolPath
        get(): TSchoolPath = tUserSchool().tSchool()
    public override fun `as`(alias: String): UserTable = UserTable(DSL.name(alias), this)
    public override fun `as`(alias: Name): UserTable = UserTable(alias, this)
    public override fun `as`(alias: Table<*>): UserTable = UserTable(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    public override fun rename(name: String): UserTable = UserTable(DSL.name(name), null)

    /**
     * Rename this table
     */
    public override fun rename(name: Name): UserTable = UserTable(name, null)

    /**
     * Rename this table
     */
    public override fun rename(name: Table<*>): UserTable = UserTable(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    public override fun where(condition: Condition): UserTable = UserTable(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    public override fun where(conditions: Collection<Condition>): UserTable = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    public override fun where(vararg conditions: Condition): UserTable = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    public override fun where(condition: Field<Boolean?>): UserTable = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL public override fun where(condition: SQL): UserTable = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL public override fun where(@Stringly.SQL condition: String): UserTable = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL public override fun where(@Stringly.SQL condition: String, vararg binds: Any?): UserTable = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL public override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): UserTable = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    public override fun whereExists(select: Select<*>): UserTable = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    public override fun whereNotExists(select: Select<*>): UserTable = where(DSL.notExists(select))
}
