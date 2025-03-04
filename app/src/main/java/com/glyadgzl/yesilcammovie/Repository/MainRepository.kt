import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainRepository{
    private val firebaseDatabase= FirebaseDatabase.getInstance()

    fun loadUpcoming(): LiveData<MutableList<FilmItemModel>> {
        val listData= MutableLiveData<MutableList<FilmItemModel>>()
      val ref=  firebaseDatabase.getReference("Upcoming")
        ref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists=mutableListOf<FilmItemModel>()
                for (i in snapshot.children){
                    val item=i.getValue(FilmItemModel::class.java)
                    item?.let{lists.add(it)}
                }
                listData.value=lists
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("MainRepository",error.message)
            }

        })
        return listData
    }

    fun loadItems():LiveData<MutableList<FilmItemModel>>{
        val listData=MutableLiveData<MutableList<FilmItemModel>>()
      val ref=  firebaseDatabase.getReference("Items")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists=mutableListOf<FilmItemModel>()
                for (i in snapshot.children){
                    val item=i.getValue(FilmItemModel::class.java)
                    item?.let{lists.add(it)}
                }
                listData.value=lists
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("MainRepository",error.message)
            }

        })
        return listData
    }
}