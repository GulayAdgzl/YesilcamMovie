@Composable
fun FilmItem(item: FilmItemModel, onItemClick: (FilmItemModel) -> Unit) {
    Column(
        modifier = Modifier
            .padding(4.dp)
            .width(120.dp)
            .clickable { onItemClick(item) }
            .background(color = Color(android.graphics.Color.parseColor("#2f22f39")))
    ) {
        AsyncImage(
            model = item.Poster,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 120.dp, height = 180.dp)
                .background(Color.Gray)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = item.Title,
            modifier = Modifier.padding(start = 4.dp),
            style = TextStyle(color = Color.White, fontSize = 11.sp),
            maxLines=1
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 4.dp,bottom=4.dp)
        ){
            Icon(
                imageVector=Icons.Filled.Star,
                contentDescription=null,
                tint=Color.Yellow,
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text=item.imdb.toString(),
                style=TextStyle(color=Color.White,style=TextStyle(color=Color.White,fontSize=11.sp))
            )
        }
    }
}
