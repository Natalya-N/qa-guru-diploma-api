package models.author;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AuthorModel {

    private Integer id;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("full_rodit")
    private String fullRodit;

    private String url;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("arts_count")
    private Integer artsCount;

    private String role;

    @JsonProperty("total_followers")
    private Integer totalFollowers;

    @JsonProperty("about_author")
    private String aboutAuthor;

    @JsonProperty("about_author_html")
    private String aboutAuthorHtml;

    @JsonProperty("reviews_count")
    private Integer reviewsCount;

    @JsonProperty("text_arts_count")
    private Integer textArtsCount;

    @JsonProperty("audio_arts_count")
    private Integer audioArtsCount;

    @JsonProperty("podcast_arts_count")
    private Integer podcastArtsCount;

    @JsonProperty("series_count")
    private Integer seriesCount;

    @JsonProperty("interviews_count")
    private Integer interviewsCount;

}
