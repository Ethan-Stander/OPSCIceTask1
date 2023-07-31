package com.example.trumpdumpapi

data class Quote(
    val quote_id: String,
    val appeared_at: String,
    val created_at: String,
    val updated_at: String,
    val value: String,
    val tags: List<String>,
    val _embedded: Embedded,
    val _links: Links
)

data class Embedded(
    val author: List<Author>,
    val source: List<Source>
)

data class Author(
    val author_id: String,
    val name: String,
    val bio: String?,
    val slug: String,
    val _links: AuthorLinks
)

data class AuthorLinks(
    val self: Link
)

data class Source(
    val quote_source_id: String,
    val created_at: String,
    val updated_at: String,
    val url: String,
    val _links: SourceLinks
)

data class SourceLinks(
    val self: Link
)

data class Links(
    val self: Link,
    val first: Link?,
    val prev: Link?,
    val next: Link?,
    val last: Link?
)

data class Link(
    val href: String
)

data class QuoteResponse(
    val count: Int,
    val total: Int,
    val _embedded: EmbeddedQuotes,
    val _links: Links
)
data class EmbeddedQuotes(
    val quotes: List<Quote>
)