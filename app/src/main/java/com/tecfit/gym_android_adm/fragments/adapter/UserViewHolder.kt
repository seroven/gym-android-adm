package com.tecfit.gym_android_adm.fragments.adapter

import android.telecom.Call.Details
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.tecfit.gym_android_adm.R
import com.tecfit.gym_android_adm.activities.utilities.ForFragments
import com.tecfit.gym_android_adm.fragments.DetailsUserFragment
import com.tecfit.gym_android_adm.models.User

private var detailsUserFragment = DetailsUserFragment()

class UserViewHolder (val view: View, val bottomSheetDialogDetails: BottomSheetDialog, val manager:FragmentManager?) : RecyclerView.ViewHolder(view){

    val user_item = view.findViewById<LinearLayout>(R.id.item_user)

    val user_image=view.findViewById<ImageView>(R.id.item_user_image)
    val user_name=view.findViewById<TextView>(R.id.item_user_name)
    //icono verde para usuarios con membresia activa -> cambiar visibility a false si no cuenta con una membresia
    val user_status=view.findViewById<LinearLayout>(R.id.item_user_status)

    fun render(user:User){
        user_name.text=user.name
        if(user.image!=null){ Glide.with(view.context).load(user.image.url).into(user_image) }

        if(user.membership!=true){ user_status.visibility=View.INVISIBLE }


        user_item.setOnClickListener{
            ForFragments.replaceInFragment(detailsUserFragment, manager)
        }
    }




}