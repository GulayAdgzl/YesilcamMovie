import java.io.Serializable
data class FilmItemModel(
    var Title:String="",
    var Year:Int=0,
    var Poster:String="",
    var imdb:Int=0,
    var Description:String="",
    var Time:String="",
    var Casts:ArrayList<CastModel> = ArrayList()
):Serializable