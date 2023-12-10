package de.timolia.howto.rank

import de.timolia.howto.conversion.SQLApi
import de.timolia.howto.minecraft.MojangService
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class TeamlerRankChange {
    val name: String
    val uuid: UUID
    val rankFrom: Rank
    val rankTo: Rank
    val date: Date

    @Transient
    private val hidden: Boolean

    constructor(name: String, rankFrom: String, rankTo: String, date: String) {
        this.name = name
        uuid = SQLApi.getUuid(name)!!
        this.rankFrom = RankConversion.getRank(rankFrom) ?: throw IllegalArgumentException("Der Rang von '$name' ('$rankFrom') existiert nicht")
        this.rankTo = RankConversion.getRank(rankTo) ?: throw IllegalArgumentException("Der Rang von '$name' ('$rankTo') existiert nicht")
        this.date = simpleDateFormat.parse(date)
        hidden = false
    }

    constructor(name: String?, uuid: UUID, rankFrom: Rank, rankTo: Rank, date: String, hidden: Boolean) {
        this.name = try {
            MojangService.nameFromUUid(uuid.toString())
        } catch (exception: Exception) {
            exception.printStackTrace()
            name!!
        }
        this.uuid = uuid
        this.rankFrom = rankFrom
        this.rankTo = rankTo
        this.date = toDate(date)
        this.hidden = hidden
    }

    fun getNameForMarkdown(): String {
        return name.replace("_".toRegex(), "\\\\_")
    }

    fun getReadableDate(): String {
        return simpleDateFormat.format(date)
    }

    override fun toString(): String {
        return "TeamlerRankChange{" +
                "name='" + name + '\'' +
                ", uuid=" + uuid +
                ", rankFrom='" + rankFrom + '\'' +
                ", rankTo='" + rankTo + '\'' +
                ", date=" + simpleDateFormat.format(date) +
                '}'
    }

    companion object {
        private val simpleDateFormat: SimpleDateFormat = SimpleDateFormat("dd.MM.yyyy")
        fun toString(date: Date?): String {
            return if (date == Date(0)) {
                "initial"
            } else simpleDateFormat.format(date)
        }

        fun toDate(date: String): Date {
            return if (date == "initial") {
                Date(0)
            } else try {
                simpleDateFormat.parse(date)
            } catch (e: ParseException) {
                throw RuntimeException(e)
            }
        }
    }
}
