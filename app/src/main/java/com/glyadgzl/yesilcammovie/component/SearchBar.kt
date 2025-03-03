@Composable
@Preview
fun SearchBar(hint:String=""){
    Row(
        modifier=Modifier.padding(horizontal=16.dp).fillMaxWidth().height(50.dp).background(
            color=Color(0x20ffffff),
            shape=RoundedCornerShape(50.dp)
        )
        .padding(horizontal=50.dp),
        verticalAlignment=Alignment.CenterVertically

    ){
        Icon(
            painter=painterResource(id = R.drawable.search),
            contentDescription=null,
            tint=Color.White,
            modifier=Modifier.size(24.dp)
        )
    }

}