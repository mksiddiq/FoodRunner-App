package com.siddiq.foodrunner.fragment

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.siddiq.foodrunner.R
import com.siddiq.foodrunner.adapter.FavouritesRecyclerAdapter
import com.siddiq.foodrunner.database.RestaurantDatabase
import com.siddiq.foodrunner.database.RestaurantEntity
import com.siddiq.foodrunner.model.Restaurant

/**
 * A simple [Fragment] subclass.
 * Use the [FavouriteRestaurantFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavouriteRestaurantFragment : Fragment() {
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var progressBar: ProgressBar
    lateinit var progressLayout: RelativeLayout
    lateinit var recyclerViewAdapter: FavouritesRecyclerAdapter
    lateinit var favouritesRecyclerView: RecyclerView

    var dbRestaurantList = listOf<RestaurantEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favourite_restaurant, container, false)

        layoutManager = LinearLayoutManager(activity)
        progressBar = view.findViewById(R.id.progressBar)
        progressLayout = view.findViewById(R.id.progressLayout)
        favouritesRecyclerView = view.findViewById(R.id.favouritesRecyclerView)

        dbRestaurantList = RetrieveFavourites(activity as Context).execute().get()

        if(dbRestaurantList!=null && activity!=null){
            progressLayout.visibility = View.GONE
            recyclerViewAdapter = FavouritesRecyclerAdapter(activity as Context, dbRestaurantList)
            favouritesRecyclerView.adapter = recyclerViewAdapter
            favouritesRecyclerView.layoutManager = layoutManager
        }

        return view
    }

    class RetrieveFavourites(val context: Context) : AsyncTask<Void, Void, List<RestaurantEntity>>(){
        override fun doInBackground(vararg p0: Void?): List<RestaurantEntity> {
            val db = Room.databaseBuilder(context, RestaurantDatabase::class.java, "restaurants-db").build()

            return db.restaurantDao().getAllRestaurants()
        }

    }


}