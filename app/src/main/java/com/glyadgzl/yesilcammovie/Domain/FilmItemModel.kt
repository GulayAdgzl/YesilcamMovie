data class FilmItemModel(
    var Title:String="",
    var Year:String="",
    var Poster:String="",
    var imdb:String="",
    var Description:String="",
    var Time:String="",
    var Casts:ArrayList<CastModel> = ArrayList()
):Serializable