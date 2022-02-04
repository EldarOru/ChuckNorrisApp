package com.example.chucknorrisapp.presentation.fragments

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.*
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.chucknorrisapp.databinding.WebFragmentBinding
import android.webkit.WebView




class WebFragment: Fragment() {
    private lateinit var webFragmentBinding: WebFragmentBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        webFragmentBinding = WebFragmentBinding.inflate(inflater, container, false)
        return webFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webFragmentBinding.webView.webViewClient = WebViewClient()
        webFragmentBinding.webView.apply {
            loadUrl(BASE_URL)
            settings.javaScriptEnabled = true
            settings.setSupportZoom(true)
        }

        //сохранение состояния
        if (savedInstanceState != null)
            (savedInstanceState.getBundle("webViewState")?.let {
                webFragmentBinding.webView.restoreState(
                    it
                )
            })

        //реализация кнопки back - переход на прошлую страницу
        webFragmentBinding.webView.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
                if (event.action === KeyEvent.ACTION_DOWN) {
                    val webView = v as WebView
                    when (keyCode) {
                        KeyEvent.KEYCODE_BACK -> if (webView.canGoBack()) {
                            webView.goBack()
                            return true
                        }
                    }
                }
                return false
            }
        })
    }

    companion object{
        private const val BASE_URL = "http://www.icndb.com/api/"
    }

}