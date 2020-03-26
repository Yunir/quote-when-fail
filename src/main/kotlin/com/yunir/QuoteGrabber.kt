package com.yunir

import org.jsoup.Jsoup
import org.jsoup.nodes.Element

class QuoteGrabber {
    fun grabNewQuote() {
        try{
            val doc = Jsoup.connect("http://bash.org/?random").get()
            val link: Element = doc.select("p.qt").first()
            link.select("br").append("\\n")
            println(link.text().replace("\\n ", "\n"))
        } catch (npe : IllegalStateException) {
            println("Resource with quotes is unreachable")
        }
    }
}