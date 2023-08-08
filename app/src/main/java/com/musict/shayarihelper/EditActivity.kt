package com.musict.shayarihelper

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.musict.shayarihelper.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        initview()
    }

    private fun initview() {
        class EditActivity : AppCompatActivity() {
            var id : Int = 0
            lateinit var title : String
            lateinit var Shayri : String
            var currentindex = 0
            var img = arrayOf(
                R.drawable.back_arrow,
                R.drawable.back_arrow,
                R.drawable.back_arrow,
                R.drawable.back_arrow,
                R.drawable.back_arrow ,
//        R.drawable.bg,
//        R.drawable.bg2,
//        R.drawable.bg3,
//        R.drawable.bg4,
//        R.drawable.bg5
            )

            lateinit var  binding : ActivityEditBinding
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                binding = ActivityEditBinding.inflate(layoutInflater)
                setContentView(binding.root)
                initview()
            }

            private fun initview() {
                if(intent!=null) {
                    id = intent.getIntExtra("Id",id)
                    title = intent.getStringExtra("title").toString()
                    Shayri = intent.getStringExtra("Shayri").toString()

                    binding.txttitle.text = title
                    binding.txtshayri.text = Shayri
                }
                binding.bgimg.setOnClickListener {
                    binding.bgimg.visibility = ImageView.VISIBLE

                    Background()
                }
                binding.imgDownload.setOnClickListener {
                    val pic: View =binding.layoutdownload
                    pic.isDrawingCacheEnabled=true
                    val hight:Int=pic.height
                    val width:Int=pic.width
                    pic.layout(0,0,width,hight)
                    pic.buildDrawingCache(true)
                    val bm: Bitmap = Bitmap.createBitmap(pic.drawingCache)
                    pic.isDrawingCacheEnabled=false
                    Toast.makeText(this, "Image Saved", Toast.LENGTH_SHORT).show()
                    MediaStore.Images.Media.insertImage(contentResolver,bm,null,null)
                }
            }

            private fun Background() {
                if(currentindex>= img.size){
                    currentindex=0
                }
                binding.bgimg.setBackgroundResource(img[currentindex])
                currentindex++

            }
        }

        }
}