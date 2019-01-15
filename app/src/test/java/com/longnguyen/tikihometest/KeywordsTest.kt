package com.longnguyen.tikihometest

import com.longnguyen.tikihometest.util.StringUtil
import junit.framework.Assert.assertEquals
import org.junit.Test

class KeywordsTest {


    val sampleKeywords = mutableListOf(
            "xiaomi",
            "bitis hunter",
            "bts",
            "balo",
            "bitis hunter x",
            "tai nghe",
            "harry potter",
            "anker",
            "iphone",
            "balo nữ",
            "nguyễn nhật ánh",
            "đắc nhân tâm",
            "ipad",
            "senka",
            "tai nghe bluetooth",
            "son",
            "maybelline",
            "laneige",
            "kem chống nắng",
            "anh chính là thanh xuân của em")

    val expectedSampleKeywords = mutableListOf(
            "xiaomi",
            "bitis\nhunter",
            "bts",
            "balo",
            "bitis\nhunter x",
            "tai\nnghe",
            "harry\npotter",
            "anker",
            "iphone",
            "balo\nnữ",
            "nguyễn\nnhật ánh",
            "đắc nhân\ntâm",
            "ipad",
            "senka",
            "tai nghe\nbluetooth",
            "son",
            "maybelline",
            "laneige",
            "kem chống\nnắng",
            "anh chính là\nthanh xuân của em")

    @Test
    fun testHandleKeyword() {
        for (i in 0 until sampleKeywords.size) {
            assertEquals(StringUtil.handleKeywords(sampleKeywords[i]), expectedSampleKeywords[i])
        }
    }

}