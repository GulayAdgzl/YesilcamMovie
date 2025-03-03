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
        Spacer(modifier=Modifier.width(8.dp))
        TextField(value="",
        onValueChange={},
        placeholder={Text(text=hint,color=Color(0xffbdbdbd))},
        colors=TextFieldDefaults.textFieldColors(
            cursorColor=Color.White,
            focusedIndicatorColor=Color.Transparent,
            unfocusedIndicatorColor=Color.Transparent,
            containerColor=Color.Transparent,
            focusedIndicatorColor=Color.White,
           
        
        ),
        modifier=Modifier.weight(1f).
        fillMaxWidth(),
        textStyle=TextStyle(color=Color.White,fontSize=16.sp),
        singleLine=true,
        shape=RoundedCornerShape(50.dp)
        )
    }

}