
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import org.jetbrains.annotations.Async

@Composable
fun FilmItem(item: FilmItemModel, onItemClick: (FilmItemModel) -> Unit) {
    Column(
        modifier = Modifier
            .padding(4.dp)
            .width(120.dp)
            .clickable { onItemClick(item) }
            .background(color = Color(android.graphics.Color.parseColor("#2f2f39")))
    ) {
        AsyncImage(
            model = item.Poster,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 120.dp, height = 180.dp)
                .background(androidx.compose.ui.graphics.Color.Gray)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = item.Title,
            modifier = Modifier.padding(start = 4.dp),
            style = TextStyle(color =androidx.compose.ui.graphics.Color.White, fontSize = 11.sp),
            maxLines=1
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 4.dp,bottom=4.dp)
        ){
            Icon(
                imageVector= Icons.Filled.Star,
                contentDescription=null,
                tint=androidx.compose.ui.graphics.Color.Yellow,
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text=item.imdb.toString(),
                style=TextStyle(color=androidx.compose.ui.graphics.Color.White,fontSize=11.sp)
            )
        }
    }
}
