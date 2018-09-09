package com.danielecampogiani.instatools.getdirectlink.usecase

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.fail
import org.junit.Test

class ParserKtTest {

    @Test
    fun parseDirectLinkSinglePhoto() {

        val directLinks = com.danielecampogiani.instatools.getdirectlink.usecase.parseDirectLinks(SINGLE_POST_HTML)

        directLinks.fold(
            { fail() },
            {
                assertEquals(
                    GetDirectLinkUseCase.Result.SinglePhoto("https://scontent-mxp1-1.cdninstagram.com/vp/4c44a0c2e95b0c916dc34dba56392c2b/5B7E8EF5/t51.2885-15/e35/31421812_1813815908922187_183717513849208832_n.jpg"),
                    it
                )
            }
        )
    }

    @Test
    fun parseDirectLinkMultiplePhotos() {

        val directLinks = com.danielecampogiani.instatools.getdirectlink.usecase.parseDirectLinks(MULTIPLE_POST_HTML)

        directLinks.fold(
            { fail() },
            {
                assertEquals(
                    GetDirectLinkUseCase.Result.MultiplePhotos(
                        listOf(
                            "https://scontent-mxp1-1.cdninstagram.com/vp/45552ea053442f3ed2cc04ce70a3030f/5BD6B6D0/t51.2885-15/e35/36113472_1835446843180291_3453440790187999232_n.jpg",
                            "https://scontent-mxp1-1.cdninstagram.com/vp/83e4e58be2c9d497a207c28f76b16505/5BD24E05/t51.2885-15/e35/35278952_244351252820597_6395226090658332672_n.jpg",
                            "https://scontent-mxp1-1.cdninstagram.com/vp/fda71289795bd83abf6f4d3f8ec51844/5BC69DF2/t51.2885-15/e35/36147967_362718267589296_8121448192236584960_n.jpg"
                        )
                    ), it
                )
            }
        )
    }
}

private const val SINGLE_POST_HTML = """
   <!DOCTYPE html>
<html lang="en" class="no-js not-logged-in client-root">
    <head><meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>
Daniele Campogiani on Instagram: “Seat switch  #smile #photooftheday #nice #cats #cat #lovecats #kitten #furry #catsagram #catstagram #petsagram #fun #catsofinstagram…”
</title>


        <meta name="robots" content="noimageindex, noarchive">
        <meta name="mobile-web-app-capable" content="yes">
        <meta name="theme-color" content="#000000">
        <meta id="viewport" name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=5, viewport-fit=cover">


        <link rel="manifest" href="/data/manifest.json">


          <link href="https://graph.instagram.com" rel="preconnect" crossorigin>



        <link rel="preload" href="/static/bundles/base/PostPageContainer.js/e628f720168b.js" as="script" type="text/javascript" crossorigin="anonymous" />

        <script type="text/javascript">
        (function() {
            var docElement = document.documentElement;
            var classRE = new RegExp('(^|\\s)no-js(\\s|${'$'})');
            var className = docElement.className;
            docElement.className = className.replace(classRE, '${'$'}1js${'$'}2');
        })();
        </script>
        <script type="text/javascript">
(function() {
  if ('PerformanceObserver' in window && 'PerformancePaintTiming' in window) {
    window.__bufferedPerformance = [];
    var ob = new PerformanceObserver(function(e) {
      window.__bufferedPerformance.push.apply(window.__bufferedPerformance,e.getEntries());
    });
    ob.observe({entryTypes:['paint']});
  }
  window.__bufferedErrors = [];
  window.onerror = function(message, url, line, column, error) {
    window.__bufferedErrors.push({
      message: message,
      url: url,
      line: line,
      column: column,
      error: error
    });
    return false;
  };
  window.__initialData = {
    pending: true,
    waiting: []
  };
  function notifyLoaded(item, data) {
    item.pending = false;
    item.data = data;
    for (var i = 0;i < item.waiting.length; ++i) {
      item.waiting[i].resolve(item.data);
    }
    item.waiting = [];
  }
  function notifyError(item, msg) {
    item.pending = false;
    item.error = new Error(msg);
    for (var i = 0;i < item.waiting.length; ++i) {
      item.waiting[i].reject(item.error);
    }
    item.waiting = [];
  }
  window.__initialDataLoaded = function(initialData) {
    notifyLoaded(window.__initialData, initialData);
  };
  window.__initialDataError = function(msg) {
    notifyError(window.__initialData, msg);
  };
  window.__additionalData = {};
  window.__pendingAdditionalData = function(paths) {
    for (var i = 0;i < paths.length; ++i) {
      window.__additionalData[paths[i]] = {
        pending: true,
        waiting: []
      };
    }
  };
  window.__additionalDataLoaded = function(path, data) {
    notifyLoaded(window.__additionalData[path], data);
  };
  window.__additionalDataError = function(path, msg) {
    notifyError(window.__additionalData[path], msg);
  };
})();
</script>

                <link rel="apple-touch-icon-precomposed" sizes="76x76" href="/static/images/ico/apple-touch-icon-76x76-precomposed.png/932e4d9af891.png">
                <link rel="apple-touch-icon-precomposed" sizes="120x120" href="/static/images/ico/apple-touch-icon-120x120-precomposed.png/004705c9353f.png">
                <link rel="apple-touch-icon-precomposed" sizes="152x152" href="/static/images/ico/apple-touch-icon-152x152-precomposed.png/82467bc9bcce.png">
                <link rel="apple-touch-icon-precomposed" sizes="167x167" href="/static/images/ico/apple-touch-icon-167x167-precomposed.png/515cb4eeeeee.png">
                <link rel="apple-touch-icon-precomposed" sizes="180x180" href="/static/images/ico/apple-touch-icon-180x180-precomposed.png/94fd767f257b.png">

                    <link rel="icon" sizes="192x192" href="/static/images/ico/favicon-192.png/b407fa101800.png">



                    <link rel="mask-icon" href="/static/images/ico/favicon.svg/9d8680ab8a3c.svg" color="#262626">

                  <link rel="shortcut icon" type="image/x-icon" href="/static/images/ico/favicon.ico/dfa85bb1fd63.ico">






    <link rel="canonical" href="https://www.instagram.com/p/BirZV08AmjO/" />
    <meta content="145 Likes, 2 Comments - Daniele Campogiani (@dcampogiani) on Instagram: “Seat switch  #smile #photooftheday #nice #cats #cat #lovecats #kitten #furry #catsagram #catstagram…”" name="description" />
    <meta property="og:site_name" content="Instagram" />
    <meta property="og:title" content="Daniele Campogiani on Instagram: “Seat switch  #smile #photooftheday #nice #cats #cat #lovecats #kitten #furry #catsagram #catstagram #petsagram #fun #catsofinstagram…”" />
    <meta property="og:image" content="https://scontent-mxp1-1.cdninstagram.com/vp/4c44a0c2e95b0c916dc34dba56392c2b/5B7E8EF5/t51.2885-15/e35/31421812_1813815908922187_183717513849208832_n.jpg" />
    <meta property="og:description" content="145 Likes, 2 Comments - Daniele Campogiani (@dcampogiani) on Instagram: “Seat switch  #smile #photooftheday #nice #cats #cat #lovecats #kitten #furry #catsagram #catstagram…”" />
    <meta property="fb:app_id" content="124024574287414" />
    <meta property="og:url" content="https://www.instagram.com/p/BirZV08AmjO/" />
    <meta property="instapp:owner_user_id" content="69098" />
    <meta property="al:ios:app_name" content="Instagram" />
    <meta property="al:ios:app_store_id" content="389801252" />
    <meta property="al:ios:url" content="instagram://media?id=1777625929040947406" />
    <meta property="al:android:app_name" content="Instagram" />
    <meta property="al:android:package" content="com.instagram.android" />
    <meta property="al:android:url" content="https://www.instagram.com/p/BirZV08AmjO/" />

    <meta name="medium" content="image" />
    <meta property="og:type" content="instapp:photo" />
    <meta property="instapp:hashtags" content="pet" /><meta property="instapp:hashtags" content="catstagram" /><meta property="instapp:hashtags" content="animal" /><meta property="instapp:hashtags" content="instagramcats" /><meta property="instapp:hashtags" content="kittens" /><meta property="instapp:hashtags" content="catoftheday" /><meta property="instapp:hashtags" content="instagood" /><meta property="instapp:hashtags" content="lovecats" /><meta property="instapp:hashtags" content="cats" /><meta property="instapp:hashtags" content="ilovemycat" /><meta property="instapp:hashtags" content="sleeping" /><meta property="instapp:hashtags" content="petsagram" /><meta property="instapp:hashtags" content="fun" /><meta property="instapp:hashtags" content="instacat" /><meta property="instapp:hashtags" content="photooftheday" /><meta property="instapp:hashtags" content="nice" /><meta property="instapp:hashtags" content="animals" /><meta property="instapp:hashtags" content="lovekittens" /><meta property="instapp:hashtags" content="kitty" /><meta property="instapp:hashtags" content="cat" /><meta property="instapp:hashtags" content="catlover" /><meta property="instapp:hashtags" content="smile" /><meta property="instapp:hashtags" content="adorable" /><meta property="instapp:hashtags" content="petstagram" /><meta property="instapp:hashtags" content="catsagram" /><meta property="instapp:hashtags" content="furry" /><meta property="instapp:hashtags" content="pets" /><meta property="instapp:hashtags" content="catsofinstagram" /><meta property="instapp:hashtags" content="kitten" />

    <link rel="alternate" href="android-app://com.instagram.android/https/instagram.com/p/BirZV08AmjO/" />

    <link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/" hreflang="x-default" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=en" hreflang="en" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=fr" hreflang="fr" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=it" hreflang="it" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=de" hreflang="de" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=es" hreflang="es" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=zh-cn" hreflang="zh-cn" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=zh-tw" hreflang="zh-tw" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=ja" hreflang="ja" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=ko" hreflang="ko" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=pt" hreflang="pt" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=pt-br" hreflang="pt-br" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=af" hreflang="af" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=cs" hreflang="cs" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=da" hreflang="da" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=el" hreflang="el" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=fi" hreflang="fi" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=hr" hreflang="hr" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=hu" hreflang="hu" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=id" hreflang="id" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=ms" hreflang="ms" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=nb" hreflang="nb" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=nl" hreflang="nl" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=pl" hreflang="pl" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=ru" hreflang="ru" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=sk" hreflang="sk" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=sv" hreflang="sv" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=th" hreflang="th" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=tl" hreflang="tl" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=tr" hreflang="tr" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=hi" hreflang="hi" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=bn" hreflang="bn" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=gu" hreflang="gu" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=kn" hreflang="kn" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=ml" hreflang="ml" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=mr" hreflang="mr" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=pa" hreflang="pa" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=ta" hreflang="ta" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=te" hreflang="te" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=ne" hreflang="ne" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=si" hreflang="si" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=ur" hreflang="ur" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=vi" hreflang="vi" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=bg" hreflang="bg" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=fr-ca" hreflang="fr-ca" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=ro" hreflang="ro" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=sr" hreflang="sr" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=uk" hreflang="uk" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=zh-hk" hreflang="zh-hk" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=es-la" hreflang="es-ec" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=es-la" hreflang="es-co" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=es-la" hreflang="es-py" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=es-la" hreflang="es-ni" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=es-la" hreflang="es-bo" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=es-la" hreflang="es-cl" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=es-la" hreflang="es-cr" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=es-la" hreflang="es-hn" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=es-la" hreflang="es-cu" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=es-la" hreflang="es-gt" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=es-la" hreflang="es-pe" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=es-la" hreflang="es-ar" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=es-la" hreflang="es-pr" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=es-la" hreflang="es-sv" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=es-la" hreflang="es-uy" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=es-la" hreflang="es-ve" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=es-la" hreflang="es-pa" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=es-la" hreflang="es-do" />
<link rel="alternate" href="https://www.instagram.com/p/BirZV08AmjO/?hl=es-la" hreflang="es-mx" />

</head>
    <body class="">

    <span id="react-root"></span>




            <script type="text/javascript">window._sharedData = {"activity_counts":null,"config":{"csrf_token":"x40YwuRakdY6pnJbsnTzUGsAJ1uHeZel","viewer":null},"supports_es6":false,"country_code":"IT","language_code":"en","locale":"en_US","entry_data":{"PostPage":[{"graphql":{"shortcode_media":{"__typename":"GraphImage","id":"1777625929040947406","shortcode":"BirZV08AmjO","dimensions":{"height":1080,"width":1080},"gating_info":null,"media_preview":"ACoqZDHtwSMk1pMfLQuRgAZxVe2Yk8g8D9KdNcZJjdSVI9Of8j25oAypLqSQ5yVHYA4A/wAauWlyX+SQ56cnrz/OoZbaNV3KxyO2P84qGF0Q7jnjtQBpyRlMtGAxPBDUxNN3qGJxkA9PWovtPmhh0AFS7pBwGOB70AVLcnPD4+v8q2UZjz8p+lc6h9atxheo4+mRQBdusynyujbc89Dz6/hWR5L5IwSR1x2qeZyr5BOQOuc0wXLAk9z3oAEj29eDxu9hn+dWTOnr+hqorZByfvHn8KjJFACIcVbjYd8GqIqVaAHzctmoCae1RmgBd1JmkpKAP//Z","display_url":"https://scontent-mxp1-1.cdninstagram.com/vp/4c44a0c2e95b0c916dc34dba56392c2b/5B7E8EF5/t51.2885-15/e35/31421812_1813815908922187_183717513849208832_n.jpg","display_resources":[{"src":"https://scontent-mxp1-1.cdninstagram.com/vp/ab211350796dfc41837605dc337de3b7/5B93DA94/t51.2885-15/s640x640/sh0.08/e35/31421812_1813815908922187_183717513849208832_n.jpg","config_width":640,"config_height":640},{"src":"https://scontent-mxp1-1.cdninstagram.com/vp/2a7e9e517267890c8621ecd0629970d8/5B9958B9/t51.2885-15/s750x750/sh0.08/e35/31421812_1813815908922187_183717513849208832_n.jpg","config_width":750,"config_height":750},{"src":"https://scontent-mxp1-1.cdninstagram.com/vp/4c44a0c2e95b0c916dc34dba56392c2b/5B7E8EF5/t51.2885-15/e35/31421812_1813815908922187_183717513849208832_n.jpg","config_width":1080,"config_height":1080}],"is_video":false,"should_log_client_event":false,"tracking_token":"eyJ2ZXJzaW9uIjo1LCJwYXlsb2FkIjp7ImlzX2FuYWx5dGljc190cmFja2VkIjpmYWxzZSwidXVpZCI6IjNjMDRmZjEzOTkwZDRmNTBhOTQ2YzFmZWVlOGFiYTFhMTc3NzYyNTkyOTA0MDk0NzQwNiJ9LCJzaWduYXR1cmUiOiIifQ==","edge_media_to_tagged_user":{"edges":[]},"edge_media_to_caption":{"edges":[{"node":{"text":"Seat switch \n#smile #photooftheday #nice #cats #cat #lovecats #kitten #furry #catsagram #catstagram #petsagram #fun #catsofinstagram #lovekittens #instacat #instagramcats #adorable #pets #catlover #ilovemycat #kittens #catoftheday #animal #pet #instagood #petstagram #kitty #sleeping #animals"}}]},"caption_is_edited":false,"edge_media_to_comment":{"count":1,"page_info":{"has_next_page":false,"end_cursor":null},"edges":[{"node":{"id":"17946978193016374","text":"\u2764\u2764\u2764\u2764","created_at":1526129950,"owner":{"id":"778032116","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/1b8ecfa1559bb5f36a2f687086a810bb/5B9883DE/t51.2885-19/s150x150/31557013_224429914984797_2360714042508574720_n.jpg","username":"ploy_ayanggoon"}}}]},"comments_disabled":false,"taken_at_timestamp":1526129545,"edge_media_preview_like":{"count":145,"edges":[{"node":{"id":"7475107511","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/3dd2634c373a5137450c9f440ff7ed20/5B7EBB99/t51.2885-19/s150x150/29738826_202000463734298_7176899633040326656_n.jpg","username":"tigris.oldking"}},{"node":{"id":"7679707391","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/1435cb011ed35b660972f6d54790fcdf/5B91FAB8/t51.2885-19/s150x150/31429550_585366055152112_6097121133721550848_n.jpg","username":"flavamim"}},{"node":{"id":"7510457417","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/f1457caae6749501d8201b7d99626d97/5B935B3B/t51.2885-19/s150x150/30086735_564966740552868_5125739104918568960_n.jpg","username":"rishiyadav70017"}},{"node":{"id":"7003743520","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/3cd50770b687fddd62c2c85a0a2d2928/5B97F499/t51.2885-19/s150x150/29403432_232113050862195_5086803967954911232_n.jpg","username":"karenyarelispr"}},{"node":{"id":"6974572659","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/9f2e71c90fa8c8cfbca2af88657e90ee/5B768D95/t51.2885-19/s150x150/26870039_139328246762372_8640465212949921792_n.jpg","username":"alex.corvera98"}},{"node":{"id":"7060442014","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/d0d4b7f5f08f2a13e5163e7323c70a1f/5B81B709/t51.2885-19/s150x150/30856383_167304977301033_2349060327355711488_n.jpg","username":"moab_allencar"}},{"node":{"id":"7148913816","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/7c3cdcc9c22a645bf01e0ea0923e5771/5B9AF7AE/t51.2885-19/s150x150/31338851_156894568487244_1592925317645729792_n.jpg","username":"brandi.rudy"}},{"node":{"id":"6998833739","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/08e44be1295e8db6062e5e27b1d01337/5B85BDE9/t51.2885-19/s150x150/28765296_1808155712818927_2994902539704467456_n.jpg","username":"reznikartem742"}},{"node":{"id":"7016344742","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/ba9d8396fd441dff486181db20c61ecb/5B8630F2/t51.2885-19/s150x150/26865353_813068008881443_416116085406826496_n.jpg","username":"ramosmaycon03"}},{"node":{"id":"6921963917","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/d0a5704d9818f823c55d87b77af53c71/5B80CA16/t51.2885-19/s150x150/31557034_646568392341982_1144911854456274944_n.jpg","username":"connor.7674"}}]},"edge_media_to_sponsor_user":{"edges":[]},"location":null,"viewer_has_liked":false,"viewer_has_saved":false,"viewer_has_saved_to_collection":false,"owner":{"id":"69098","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/abb90f786bcc2f646c7b9b132a4a5037/5B7FF9FE/t51.2885-19/s150x150/20347436_1942490286033707_2820707715674800128_a.jpg","username":"dcampogiani","blocked_by_viewer":false,"followed_by_viewer":false,"full_name":"Daniele Campogiani","has_blocked_viewer":false,"is_private":false,"is_unpublished":false,"is_verified":false,"requested_by_viewer":false},"is_ad":false,"edge_web_media_to_related_media":{"edges":[]}}}}]},"gatekeepers":{"ld":true,"seo":true,"seoht":true,"lh":true,"saa":true},"knobs":{"acct:ntb":0,"cb":1},"qe":{"dash_for_vod":{"g":"","p":{}},"aysf":{"g":"","p":{}},"bc3l":{"g":"","p":{}},"comment_reporting":{"g":"","p":{}},"direct_conversation_reporting":{"g":"","p":{}},"direct_reporting":{"g":"","p":{}},"reporting":{"g":"","p":{}},"media_reporting":{"g":"","p":{}},"acc_recovery_link":{"g":"test","p":{"show_account_recovery_modal":"true"}},"notif":{"g":"","p":{}},"drct_nav":{"g":"","p":{}},"pl_pivot_li":{"g":"","p":{}},"pl_pivot_lo":{"g":"","p":{}},"404_as_react":{"g":"","p":{}},"acc_recovery":{"g":"test_with_cta_to_signup_02_22_18","p":{"has_cta_to_signup":"true"}},"client_gql":{"g":"","p":{}},"collections":{"g":"","p":{}},"comment_ta":{"g":"","p":{}},"connections":{"g":"","p":{}},"disc_ppl":{"g":"","p":{}},"embeds":{"g":"","p":{}},"ebdsim_li":{"g":"","p":{}},"ebdsim_lo":{"g":"","p":{}},"es6":{"g":"","p":{}},"exit_story_creation":{"g":"","p":{}},"gdpr_logged_out":{"g":"","p":{}},"appsell":{"g":"","p":{}},"imgopt":{"g":"","p":{}},"follow_button":{"g":"","p":{}},"loggedout":{"g":"launch","p":{"new_cta":"true","remove_upsell_banner":"true","update_nav":"true"}},"loggedout_upsell":{"g":"test_with_login_as_primary_cta_03_16_18","p":{"has_login_as_primary_cta":"true"}},"us_li":{"g":"","p":{}},"msisdn":{"g":"","p":{}},"bg_sync":{"g":"","p":{}},"onetaplogin":{"g":"control","p":{"after_reg":"false","storage_version":"one_tap_after_reg_v1"}},"onetaplogin_userbased":{"g":"","p":{}},"login_poe":{"g":"","p":{}},"prvcy_tggl":{"g":"","p":{}},"private_lo":{"g":"","p":{}},"profile_photo_nux_fbc_v2":{"g":"","p":{}},"push_notifications":{"g":"","p":{}},"reg":{"g":"test_03_29","p":{"show_continue_in_login_form":"true"}},"reg_vp":{"g":"","p":{}},"feed_vp":{"g":"","p":{}},"report_haf":{"g":"","p":{}},"report_media":{"g":"","p":{}},"report_profile":{"g":"","p":{}},"save":{"g":"","p":{}},"sidecar":{"g":"","p":{}},"su_universe":{"g":"","p":{}},"stale":{"g":"","p":{}},"stories_lo":{"g":"test_03_15","p":{"stories_profile":"true"}},"stories":{"g":"","p":{}},"tp_pblshr":{"g":"","p":{}},"video":{"g":"","p":{}},"gdpr_settings":{"g":"","p":{}},"gdpr_eu_tos":{"g":"","p":{}},"gdpr_row_tos":{"g":"","p":{}},"fd_gr":{"g":"","p":{}},"felix":{"g":"","p":{}}},"hostname":"www.instagram.com","platform":"web","rhx_gis":"afc8d9f759cc22aaa925be4c11b6fb14","nonce":"Ke+wbcR0NCJPtdio3TvYQA==","zero_data":{},"rollout_hash":"0fa00dc2cc1f","bundle_variant":"base","probably_has_app":false,"show_app_install":true};</script><script type="text/javascript">
        window.__useAsyncEntrypoints = true;
        window.__initialDataLoaded(window._sharedData);
        </script>
            <script type="text/javascript" src="/static/bundles/base/Polyfills.js/d5d44088527a.js" crossorigin="anonymous"></script>
            <script type="text/javascript" src="/static/bundles/base/Vendor.js/1e47317bb9bf.js" crossorigin="anonymous"></script>
<script type="text/javascript">!function(e){var a=window.webpackJsonp;window.webpackJsonp=function(n,r,c){for(var i,d,b,f=0,s=[];f<n.length;f++)d=n[f],o[d]&&s.push(o[d][0]),o[d]=0;for(i in r)Object.prototype.hasOwnProperty.call(r,i)&&(e[i]=r[i]);for(a&&a(n,r,c);s.length;)s.shift()();if(c)for(f=0;f<c.length;f++)b=t(t.s=c[f]);return b};var n={},o={66:0};function t(a){if(n[a])return n[a].exports;var o=n[a]={i:a,l:!1,exports:{}};return e[a].call(o.exports,o,o.exports,t),o.l=!0,o.exports}t.e=function(e){var a=o[e];if(0===a)return new Promise(function(e){e()});if(a)return a[2];var n=new Promise(function(n,t){a=o[e]=[n,t]});a[2]=n;var r=document.getElementsByTagName("head")[0],c=document.createElement("script");c.type="text/javascript",c.charset="utf-8",c.async=!0,c.timeout=12e4,c.crossOrigin="anonymous",t.nc&&c.setAttribute("nonce",t.nc),c.src=t.p+""+({0:"SettingsModules",1:"MobileStoriesPage",2:"DesktopStoriesPage",3:"ProfilePageContainer",4:"LikedByListContainer",5:"FollowListContainer",6:"CreationModules",7:"LocationPageContainer",8:"DiscoverMediaPageContainer",9:"DiscoverEmbedsPageContainer",10:"TagPageContainer",11:"UserCollectionMediaPageContainer",12:"DebugInfoNub",13:"FeedPageContainer",14:"PostPageContainer",15:"LandingPage",16:"LoginAndSignupPage",17:"ResetPasswordPageContainer",18:"MobileStoriesLoginPage",19:"DesktopStoriesLoginPage",20:"FBSignupPage",21:"TermsUnblockPage",22:"DirectInboxPageContainer",23:"NewUserInterstitial",24:"DiscoverPeoplePageContainer",25:"IGTVVideoUploadPageContainer",26:"UserCollectionsPageContainer",27:"DataDownloadRequestPage",28:"MultiStepSignupPage",29:"ContactHistoryPage",30:"AccessToolViewAllPage",31:"AccessToolPage",32:"DataDownloadRequestConfirmPage",33:"DataControlsSupportPage",34:"EmailConfirmationPage",35:"LocationsDirectoryLandingPage",36:"LocationsDirectoryCountryPage",37:"LocationsDirectoryCityPage",38:"OneTapUpsell",39:"NewTermsConfirmPage",40:"SuggestedDirectoryLandingPage",41:"ProfilesDirectoryLandingPage",42:"HashtagsDirectoryLandingPage",43:"OAuthPermissionsPage",44:"DirectoryPage",45:"HttpErrorPage",46:"ActivityFeedPage",47:"StoryCreationPage",48:"ParentalConsentPage",49:"ParentalConsentNotParentPage",50:"CheckpointUnderageAppealPage",51:"AccountPrivacyBugPage",52:"ContactInvitesOptOutPage",53:"ContactInvitesOptOutStatusPage",54:"Report",55:"Copyright",56:"SupportInfo",57:"Community",58:"Verification",59:"Challenge",60:"Consumer",61:"EmailSnoozePage",62:"EmailUnsubscribePage",63:"NotificationLandingPage"}[e]||e)+".js/"+{0:"0c6c1b3588c5",1:"edcf12566780",2:"01fe464319fd",3:"a0525e69cca5",4:"a207254675f3",5:"b76cef8b19f1",6:"0e494a318d79",7:"cfa51468bc84",8:"5020c38433a6",9:"90b18b078d1c",10:"903e7d59db3f",11:"e7101ee62d62",12:"ae4230d026eb",13:"146dc84d20b1",14:"e628f720168b",15:"25e4fc0ee1f2",16:"5cdf2155a521",17:"dcf8cf57c56c",18:"97d4e1683116",19:"022a8ddeb9b8",20:"fd77b9d6e149",21:"a28e7893bc8e",22:"1e96d1b99e2a",23:"8ca399646baa",24:"e9fea0860714",25:"cfe6e06f4330",26:"3ebf318c571f",27:"b83c2114b6e4",28:"03fd080ff2c6",29:"2307a5e64769",30:"a88557405839",31:"be71ef97bf54",32:"37dd209abbe6",33:"8fb680c77dee",34:"9b12a6b25974",35:"eae921f999d5",36:"f458fc47d510",37:"eea18f6e3834",38:"c2ed25e07903",39:"50ac34aa4d16",40:"a4ebaa713b74",41:"6bfe3ce3b423",42:"b0b89cb64bed",43:"b64ca3361b05",44:"9821a1d6a97d",45:"34c151238eae",46:"0aecac2e8de5",47:"50c95a86b4ac",48:"4b1c172c1b1d",49:"317866612310",50:"f7e0f88735bf",51:"e62ac74e3d93",52:"1fc6b5604bfc",53:"8a763d40564a",54:"5c60a98b2033",55:"7833d572c56b",56:"9eb61ccf3653",57:"3bd361c6d94e",58:"c8ed97e196e6",59:"9b28de7d5707",60:"f8c6f845d357",61:"49bbbf99a532",62:"db2c4fc2485d",63:"530e04127704"}[e]+".js";var i=setTimeout(d,12e4);function d(){c.onerror=c.onload=null,clearTimeout(i);var a=o[e];0!==a&&(a&&a[1](new Error("Loading chunk "+e+" failed.")),o[e]=void 0)}return c.onerror=c.onload=d,r.appendChild(c),n},t.m=e,t.c=n,t.d=function(e,a,n){t.o(e,a)||Object.defineProperty(e,a,{configurable:!1,enumerable:!0,get:n})},t.n=function(e){var a=e&&e.__esModule?function(){return e.default}:function(){return e};return t.d(a,"a",a),a},t.o=function(e,a){return Object.prototype.hasOwnProperty.call(e,a)},t.p="/static/bundles/base/",t.oe=function(e){throw console.error(e),e}}([]);</script>
            <script type="text/javascript" src="/static/bundles/base/PostPageContainer.js/e628f720168b.js" crossorigin="anonymous" charset="utf-8" async=""></script>
<script type="text/javascript" src="/static/bundles/base/en_US.js/6cc332f27cc2.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="/static/bundles/base/ConsumerCommons.js/6a4b2bd04cbc.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="/static/bundles/base/Consumer.js/f8c6f845d357.js" crossorigin="anonymous"></script>

    </body>
</html>
    """

private const val MULTIPLE_POST_HTML = """


<!DOCTYPE html>
<html lang="it" class="no-js logged-in client-root">
    <head><meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>
Valentina Sangiorgi su Instagram: &#34;Life through a #kaleidoscope.&#34;
</title>


        <meta name="robots" content="noimageindex, noarchive">
        <meta name="mobile-web-app-capable" content="yes">
        <meta name="theme-color" content="#000000">
        <meta id="viewport" name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, viewport-fit=cover">


        <link rel="manifest" href="/data/manifest.json">


          <link href="https://graph.instagram.com" rel="preconnect" crossorigin>



        <link rel="preload" href="/static/bundles/base/PostPageContainer.js/8301b5645648.js" as="script" type="text/javascript" crossorigin="anonymous" />

        <script type="text/javascript">
        (function() {
  var docElement = document.documentElement;
  var classRE = new RegExp('(^|\\s)no-js(\\s|${'$'})');
  var className = docElement.className;
  docElement.className = className.replace(classRE, '${'$'}1js${'$'}2');
})();
</script>
        <!-- first_input_delay is a js file copied from https://fburl.com/rc21x6p3
in order to use it statically for server side rendering.
We should aim to keep it consistent with their updates -->
<!-- This is a js file copied from https://fburl.com/rc21x6p3
in order to use it statically for server side rendering.
We should aim to keep it consistent with their updates -->

<script type="text/javascript">

/*
 Copyright 2018 Google Inc. All Rights Reserved.
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/

(function(){function g(a,c){b||(b=a,f=c,h.forEach(function(a){removeEventListener(a,l,e)}),m())}function m(){b&&f&&0<d.length&&(d.forEach(function(a){a(b,f)}),d=[])}function n(a,c){function k(){g(a,c);d()}function b(){d()}function d(){removeEventListener("pointerup",k,e);removeEventListener("pointercancel",b,e)}addEventListener("pointerup",k,e);addEventListener("pointercancel",b,e)}function l(a){if(a.cancelable){var c=performance.now(),b=a.timeStamp;b>c&&(c=+new Date);c-=b;"pointerdown"==a.type?n(c,
a):g(c,a)}}var e={passive:!0,capture:!0},h=["click","mousedown","keydown","touchstart","pointerdown"],b,f,d=[];h.forEach(function(a){addEventListener(a,l,e)});window.perfMetrics=window.perfMetrics||{};window.perfMetrics.onFirstInputDelay=function(a){d.push(a);m()}})();
</script>

<script type="text/javascript">
(function() {
  if ('PerformanceObserver' in window && 'PerformancePaintTiming' in window) {
    window.__bufferedPerformance = [];
    var ob = new PerformanceObserver(function(e) {
      window.__bufferedPerformance.push.apply(window.__bufferedPerformance,e.getEntries());
    });
    ob.observe({entryTypes:['paint']});
  }
  window.__bufferedErrors = [];
  window.onerror = function(message, url, line, column, error) {
    window.__bufferedErrors.push({
      message: message,
      url: url,
      line: line,
      column: column,
      error: error
    });
    return false;
  };
  window.__initialData = {
    pending: true,
    waiting: []
  };
  function notifyLoaded(item, data) {
    item.pending = false;
    item.data = data;
    for (var i = 0;i < item.waiting.length; ++i) {
      item.waiting[i].resolve(item.data);
    }
    item.waiting = [];
  }
  function notifyError(item, msg) {
    item.pending = false;
    item.error = new Error(msg);
    for (var i = 0;i < item.waiting.length; ++i) {
      item.waiting[i].reject(item.error);
    }
    item.waiting = [];
  }
  window.__initialDataLoaded = function(initialData) {
    notifyLoaded(window.__initialData, initialData);
  };
  window.__initialDataError = function(msg) {
    notifyError(window.__initialData, msg);
  };
  window.__additionalData = {};
  window.__pendingAdditionalData = function(paths) {
    for (var i = 0;i < paths.length; ++i) {
      window.__additionalData[paths[i]] = {
        pending: true,
        waiting: []
      };
    }
  };
  window.__additionalDataLoaded = function(path, data) {
    notifyLoaded(window.__additionalData[path], data);
  };
  window.__additionalDataError = function(path, msg) {
    notifyError(window.__additionalData[path], msg);
  };
})();
</script>

                <link rel="apple-touch-icon-precomposed" sizes="76x76" href="/static/images/ico/apple-touch-icon-76x76-precomposed.png/4272e394f5ad.png">
                <link rel="apple-touch-icon-precomposed" sizes="120x120" href="/static/images/ico/apple-touch-icon-120x120-precomposed.png/02ba5abf9861.png">
                <link rel="apple-touch-icon-precomposed" sizes="152x152" href="/static/images/ico/apple-touch-icon-152x152-precomposed.png/419a6f9c7454.png">
                <link rel="apple-touch-icon-precomposed" sizes="167x167" href="/static/images/ico/apple-touch-icon-167x167-precomposed.png/a24e58112f06.png">
                <link rel="apple-touch-icon-precomposed" sizes="180x180" href="/static/images/ico/apple-touch-icon-180x180-precomposed.png/85a358fb3b7d.png">

                    <link rel="icon" sizes="192x192" href="/static/images/ico/favicon-192.png/68d99ba29cc8.png">



                    <link rel="mask-icon" href="/static/images/ico/favicon.svg/fc72dd4bfde8.svg" color="#262626">

                  <link rel="shortcut icon" type="image/x-icon" href="/static/images/ico/favicon.ico/36b3ee2d91ed.ico">






    <link rel="canonical" href="https://www.instagram.com/p/Bkp6U_ensIx/" />
    <meta content="&amp;quot;Mi piace&amp;quot;: 17, commenti: 1 - Valentina Sangiorgi (@indaco.blues) su Instagram: &amp;quot;Life through a #kaleidoscope.&amp;quot;" name="description" />
    <meta property="og:site_name" content="Instagram" />
    <meta property="og:title" content="Valentina Sangiorgi su Instagram: &#34;Life through a #kaleidoscope.&#34;" />
    <meta property="og:image" content="https://scontent-mxp1-1.cdninstagram.com/vp/45552ea053442f3ed2cc04ce70a3030f/5BD6B6D0/t51.2885-15/e35/36113472_1835446843180291_3453440790187999232_n.jpg" />
    <meta property="og:description" content="&#34;Mi piace&#34;: 17, commenti: 1 - Valentina Sangiorgi (@indaco.blues) su Instagram: &#34;Life through a #kaleidoscope.&#34;" />
    <meta property="fb:app_id" content="124024574287414" />
    <meta property="og:url" content="https://www.instagram.com/p/Bkp6U_ensIx/" />
    <meta property="instapp:owner_user_id" content="2263039274" />
    <meta property="al:ios:app_name" content="Instagram" />
    <meta property="al:ios:app_store_id" content="389801252" />
    <meta property="al:ios:url" content="instagram://media?id=1813236854239969841" />
    <meta property="al:android:app_name" content="Instagram" />
    <meta property="al:android:package" content="com.instagram.android" />
    <meta property="al:android:url" content="https://www.instagram.com/p/Bkp6U_ensIx/" />

    <meta name="medium" content="image" />
    <meta property="og:type" content="instapp:photo" />
    <meta property="instapp:hashtags" content="kaleidoscope" />

    <link rel="alternate" href="android-app://com.instagram.android/https/instagram.com/p/Bkp6U_ensIx/" />

    <link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/" hreflang="x-default" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=en" hreflang="en" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=fr" hreflang="fr" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=it" hreflang="it" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=de" hreflang="de" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=es" hreflang="es" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=zh-cn" hreflang="zh-cn" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=zh-tw" hreflang="zh-tw" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=ja" hreflang="ja" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=ko" hreflang="ko" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=pt" hreflang="pt" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=pt-br" hreflang="pt-br" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=af" hreflang="af" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=cs" hreflang="cs" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=da" hreflang="da" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=el" hreflang="el" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=fi" hreflang="fi" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=hr" hreflang="hr" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=hu" hreflang="hu" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=id" hreflang="id" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=ms" hreflang="ms" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=nb" hreflang="nb" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=nl" hreflang="nl" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=pl" hreflang="pl" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=ru" hreflang="ru" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=sk" hreflang="sk" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=sv" hreflang="sv" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=th" hreflang="th" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=tl" hreflang="tl" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=tr" hreflang="tr" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=hi" hreflang="hi" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=bn" hreflang="bn" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=gu" hreflang="gu" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=kn" hreflang="kn" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=ml" hreflang="ml" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=mr" hreflang="mr" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=pa" hreflang="pa" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=ta" hreflang="ta" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=te" hreflang="te" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=ne" hreflang="ne" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=si" hreflang="si" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=ur" hreflang="ur" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=vi" hreflang="vi" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=bg" hreflang="bg" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=fr-ca" hreflang="fr-ca" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=ro" hreflang="ro" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=sr" hreflang="sr" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=uk" hreflang="uk" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=zh-hk" hreflang="zh-hk" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=es-la" hreflang="es-gt" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=es-la" hreflang="es-ni" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=es-la" hreflang="es-pr" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=es-la" hreflang="es-ar" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=es-la" hreflang="es-pa" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=es-la" hreflang="es-cr" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=es-la" hreflang="es-mx" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=es-la" hreflang="es-py" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=es-la" hreflang="es-bo" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=es-la" hreflang="es-co" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=es-la" hreflang="es-cu" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=es-la" hreflang="es-sv" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=es-la" hreflang="es-uy" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=es-la" hreflang="es-cl" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=es-la" hreflang="es-do" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=es-la" hreflang="es-pe" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=es-la" hreflang="es-ec" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=es-la" hreflang="es-hn" />
<link rel="alternate" href="https://www.instagram.com/p/Bkp6U_ensIx/?hl=es-la" hreflang="es-ve" />

</head>
    <body class="">

    <span id="react-root"></span>




            <script type="text/javascript">window._sharedData = {"activity_counts":{"comment_likes":0,"comments":0,"likes":0,"relationships":0,"usertags":0},"config":{"csrf_token":"IQH9XOjap2gNQq8g7YnSgs2q8gCEtBqh","viewer":{"allow_contacts_sync":true,"biography":"\ud83c\uddee\ud83c\uddf9 Bologna\n\ud83d\udc68\u200d\ud83d\udcbb Software Developer\nMediocrity is useless.","external_url":"http://danielecampogiani.com/","full_name":"Daniele Campogiani","has_profile_pic":true,"id":"69098","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/6bcf16bba589d07cdffc9ad9e35081fa/5BCF13FE/t51.2885-19/s150x150/20347436_1942490286033707_2820707715674800128_a.jpg","profile_pic_url_hd":"https://scontent-mxp1-1.cdninstagram.com/vp/db25b860982609fc99cc9624e7957050/5BDAF686/t51.2885-19/s320x320/20347436_1942490286033707_2820707715674800128_a.jpg","username":"dcampogiani"}},"supports_es6":true,"country_code":"IT","language_code":"it","locale":"it_IT","entry_data":{"PostPage":[{"graphql":{"shortcode_media":{"__typename":"GraphSidecar","id":"1813236854239969841","shortcode":"Bkp6U_ensIx","dimensions":{"height":1080,"width":1080},"gating_info":null,"media_preview":null,"display_url":"https://scontent-mxp1-1.cdninstagram.com/vp/45552ea053442f3ed2cc04ce70a3030f/5BD6B6D0/t51.2885-15/e35/36113472_1835446843180291_3453440790187999232_n.jpg","display_resources":[{"src":"https://scontent-mxp1-1.cdninstagram.com/vp/339bf40607e214f8c29ce991e31923ce/5BE86C6A/t51.2885-15/sh0.08/e35/s640x640/36113472_1835446843180291_3453440790187999232_n.jpg","config_width":640,"config_height":640},{"src":"https://scontent-mxp1-1.cdninstagram.com/vp/b22e3dee80e7407605b29667d6cc841e/5BD3EFAE/t51.2885-15/sh0.08/e35/s750x750/36113472_1835446843180291_3453440790187999232_n.jpg","config_width":750,"config_height":750},{"src":"https://scontent-mxp1-1.cdninstagram.com/vp/45552ea053442f3ed2cc04ce70a3030f/5BD6B6D0/t51.2885-15/e35/36113472_1835446843180291_3453440790187999232_n.jpg","config_width":1080,"config_height":1080}],"is_video":false,"should_log_client_event":false,"tracking_token":"eyJ2ZXJzaW9uIjo1LCJwYXlsb2FkIjp7ImlzX2FuYWx5dGljc190cmFja2VkIjpmYWxzZSwidXVpZCI6IjgzMTNjYmU2ZDlmOTQ5YmFhZGM1M2E0MzJhMTlkNTJlMTgxMzIzNjg1NDIzOTk2OTg0MSIsInNlcnZlcl90b2tlbiI6IjE1MzEyMjE3MjUzNzN8MTgxMzIzNjg1NDIzOTk2OTg0MXw2OTA5OHw5ZWEzZmZjOTVkZTc0ZjRjNjBlNWNjN2ZjM2FhNzRhZjE1MTYzMjYxMmQ0Mjc0NDgzNDY2YjE5N2JjMzA2MTI2In0sInNpZ25hdHVyZSI6IiJ9","edge_media_to_tagged_user":{"edges":[]},"edge_media_to_caption":{"edges":[{"node":{"text":"Life through a #kaleidoscope."}}]},"caption_is_edited":true,"edge_media_to_comment":{"count":0,"page_info":{"has_next_page":false,"end_cursor":null},"edges":[]},"comments_disabled":false,"taken_at_timestamp":1530374698,"edge_media_preview_like":{"count":17,"edges":[{"node":{"id":"720817755","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/66d623ac6c72f54059136b21d7682b33/5BE2F262/t51.2885-19/11142253_1606164756263414_1112975917_a.jpg","username":"montagnedilibri"}},{"node":{"id":"2000020351","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/e5966bd86211ab74e592367f9a919404/5BCD2324/t51.2885-19/s150x150/30602023_162073651126241_4311023026213748736_n.jpg","username":"teepueppchen"}},{"node":{"id":"288680196","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/0608126b01449087e5ef72b2c5be324a/5BDAD921/t51.2885-19/s150x150/34187397_189927861708522_8561504549905367040_n.jpg","username":"riccardotrenteen"}},{"node":{"id":"7598769153","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/3b3a35bd5e1e56a16a3be843f00fc2ce/5BE8B89D/t51.2885-19/s150x150/36509935_1136751573130587_6106973951907332096_n.jpg","username":"alovxra"}},{"node":{"id":"3216946030","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/965b573c49284f1475013d2e99476e65/5BC6A96B/t51.2885-19/s150x150/33226303_1022318814589374_1596456085705719808_n.jpg","username":"vprettyunicorn"}},{"node":{"id":"104814913","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/588b5a26831ac3ab9542d203ff6489d2/5BC966F9/t51.2885-19/s150x150/35574300_1707329115987700_7738699596083232768_n.jpg","username":"amberjaywadham"}},{"node":{"id":"257679844","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/d1e1dc40e409b37f8fe86b010dd23502/5BCF77A8/t51.2885-19/s150x150/29087676_459643144450690_2311146370406285312_n.jpg","username":"marigall90"}},{"node":{"id":"4546857538","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/e7d0b1f25d033ddb3f5190519b52106f/5BE4F1F7/t51.2885-19/s150x150/16123958_266890677073780_715377878899884032_a.jpg","username":"stonenationco"}},{"node":{"id":"1527725031","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/6b65e038212eea1736e0613c3952c295/5BDB7002/t51.2885-19/s150x150/30079336_352851268557956_2326595878871105536_n.jpg","username":"indivem"}},{"node":{"id":"418585807","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/c0bcf49381b94820cc14a7976aa8be38/5BE56B0B/t51.2885-19/s150x150/36085801_2108528599435126_260953206358540288_n.jpg","username":"the_pale_empress_"}}]},"edge_media_to_sponsor_user":{"edges":[]},"location":{"id":"105974","has_public_page":true,"name":"Faenza","slug":"faenza"},"viewer_has_liked":false,"viewer_has_saved":false,"viewer_has_saved_to_collection":false,"viewer_in_photo_of_you":false,"owner":{"id":"2263039274","profile_pic_url":"https://scontent-mxp1-1.cdninstagram.com/vp/086cb11e9d7347f9bf337b8c1e1006c0/5BDA2AAE/t51.2885-19/s150x150/32561817_202120353916429_5377457135158296576_n.jpg","username":"indaco.blues","blocked_by_viewer":false,"followed_by_viewer":true,"full_name":"Valentina Sangiorgi","has_blocked_viewer":false,"is_private":false,"is_unpublished":false,"is_verified":false,"requested_by_viewer":false},"is_ad":false,"edge_web_media_to_related_media":{"edges":[{"node":{"shortcode":"Bggy60QHFhU","thumbnail_src":"https://scontent-mxp1-1.cdninstagram.com/vp/b52e40dc7f1e353d8f9871f61b5ecfde/5B46D431/t51.2885-15/sh0.08/e35/s640x640/28753624_719425878446066_7676196667896365056_n.jpg"}},{"node":{"shortcode":"BkDm-k7gXkJ","thumbnail_src":"https://scontent-mxp1-1.cdninstagram.com/vp/8a4710e88ee77fbd774b549372cbbd7b/5BEB0A96/t51.2885-15/sh0.08/e35/s640x640/34791538_177934419553815_6019510915769040896_n.jpg"}},{"node":{"shortcode":"Biu7plNnxHl","thumbnail_src":"https://scontent-mxp1-1.cdninstagram.com/vp/50d9048a2bc08122e28767e0b5ce1fdb/5BDD974A/t51.2885-15/sh0.08/e35/s640x640/31557126_398604810641482_920908367709339648_n.jpg"}},{"node":{"shortcode":"BkBG8mkgnZS","thumbnail_src":"https://scontent-mxp1-1.cdninstagram.com/vp/9b8009af62eaf6128000a5e04801b909/5BD9991A/t51.2885-15/sh0.08/e35/s640x640/32589892_974488369391049_768225445727436800_n.jpg"}},{"node":{"shortcode":"BaUHz02Fwnd","thumbnail_src":"https://scontent-mxp1-1.cdninstagram.com/vp/e7dde72c03be957e44cee1e8d30d4c61/5BC72664/t51.2885-15/sh0.08/e35/s640x640/22430546_1871635716498884_2960917468513566720_n.jpg"}},{"node":{"shortcode":"BibyL15AUGp","thumbnail_src":"https://scontent-mxp1-1.cdninstagram.com/vp/375f6e6ff1cb65b7d229e4a579889429/5BDF8D78/t51.2885-15/sh0.08/e35/s640x640/31680510_738901279833964_5370798776208326656_n.jpg"}},{"node":{"shortcode":"BgYgfyTHulO","thumbnail_src":"https://scontent-mxp1-1.cdninstagram.com/vp/3be3715884d5556653f38ac3a70a623d/5BE1EF0D/t51.2885-15/sh0.08/e35/s640x640/28754184_2013509265588329_2587797759541116928_n.jpg"}},{"node":{"shortcode":"BkDONo3AWze","thumbnail_src":"https://scontent-mxp1-1.cdninstagram.com/vp/87d87e32031b2fc81da5f05e3ec35f74/5BD5A435/t51.2885-15/sh0.08/e35/s640x640/33962457_398483783999661_4487860504965939200_n.jpg"}},{"node":{"shortcode":"BgLcw14nosW","thumbnail_src":"https://scontent-mxp1-1.cdninstagram.com/vp/31ebdbf7d227b0ea32b94b9dd556500f/5BC894A4/t51.2885-15/sh0.08/e35/s640x640/28434229_406837356396883_7888455978889248768_n.jpg"}},{"node":{"shortcode":"Bk8021DBC5z","thumbnail_src":"https://scontent-mxp1-1.cdninstagram.com/vp/510de41b793a9a76d866dd394a5c9ebe/5BE41C8A/t51.2885-15/sh0.08/e35/c135.0.809.809/s640x640/36502530_1762375597203130_262582450662670336_n.jpg"}},{"node":{"shortcode":"BkPqL_ZBVIk","thumbnail_src":"https://scontent-mxp1-1.cdninstagram.com/vp/d38e48839829f7c2d42b2138dfbe2ea1/5BE343B5/t51.2885-15/sh0.08/e35/s640x640/34687457_250282915742400_3836733859345465344_n.jpg"}},{"node":{"shortcode":"BikTeuKFZsH","thumbnail_src":"https://scontent-mxp1-1.cdninstagram.com/vp/7cc0c134a91a0a19697738522993fd66/5BD2333A/t51.2885-15/sh0.08/e35/s640x640/31171389_2044238275826408_6838343694857273344_n.jpg"}},{"node":{"shortcode":"BkcgACYnKWW","thumbnail_src":"https://scontent-mxp1-1.cdninstagram.com/vp/91c356890f9c81d8b3804d8af6c00d3b/5BC89A36/t51.2885-15/sh0.08/e35/s640x640/35155891_475302626234456_214372971773427712_n.jpg"}},{"node":{"shortcode":"BiOklMiAsDu","thumbnail_src":"https://scontent-mxp1-1.cdninstagram.com/vp/48b5eb5ae058307c194a87a2128f602b/5BE159B1/t51.2885-15/sh0.08/e35/s640x640/31124029_433602263751785_3647395122364022784_n.jpg"}},{"node":{"shortcode":"BfzB5dWjoNo","thumbnail_src":"https://scontent-mxp1-1.cdninstagram.com/vp/9e93241539914b5b99c7216d4d9bc0ce/5BCF3B85/t51.2885-15/sh0.08/e35/s640x640/28158111_193245694793848_3564039672688541696_n.jpg"}},{"node":{"shortcode":"BhwP31HgNyL","thumbnail_src":"https://scontent-mxp1-1.cdninstagram.com/vp/8ae1e2f98cbd667e31d0344b75ef2a1b/5B471EDE/t51.2885-15/e35/30087292_442895652818722_1135504626242551808_n.jpg"}},{"node":{"shortcode":"Bcz8e6WlW7s","thumbnail_src":"https://scontent-mxp1-1.cdninstagram.com/vp/72023f7cd884ecdcdccbfadd975d5b43/5BCCE866/t51.2885-15/sh0.08/e35/c135.0.809.809/s640x640/24839085_134594903876392_535706855603699712_n.jpg"}},{"node":{"shortcode":"Bfn3HUDhE2M","thumbnail_src":"https://scontent-mxp1-1.cdninstagram.com/vp/4a5a6d1aad8050149bee794f83f6e568/5BEC0ABF/t51.2885-15/sh0.08/e35/s640x640/28151072_964297120404788_5126788322479308800_n.jpg"}},{"node":{"shortcode":"Biewb5vn6oY","thumbnail_src":"https://scontent-mxp1-1.cdninstagram.com/vp/8f28e77299707180f8703f9fdca8eb97/5BEB1B6F/t51.2885-15/sh0.08/e35/c137.0.805.805/s640x640/31788374_1867116390252954_3500205257395273728_n.jpg"}},{"node":{"shortcode":"BkcyfUsBhkg","thumbnail_src":"https://scontent-mxp1-1.cdninstagram.com/vp/a4b672e0c4ac49cf2c89e21a6c7af45b/5BDB8FA8/t51.2885-15/sh0.08/e35/c128.0.767.767/s640x640/35616777_178046639558310_1249459372849889280_n.jpg"}}]},"edge_sidecar_to_children":{"edges":[{"node":{"__typename":"GraphImage","id":"1813235190903173179","shortcode":"Bkp58yYBXA7","dimensions":{"height":1080,"width":1080},"gating_info":null,"media_preview":"ACoqw4otxGelaZhRV5X8R1qWK3wqn1FL5fNAyr5flkN1z0prv+Oa0GiATd7/AKVnOAG+tIRWkj7jvVfFarhcBc9Oc1T8s+lMDeWQYwBke/8ASoiw5Pp2qqWKnFWolDdfSkMa0xxycEdMdqquSwJ7/wCetOmUr1FKrhVIPU8Y74oAq/N0pu01dhCseCcVMYRmna5JSMiseMj0FO8/AIHC+nrVKOpm7/WgYvmFvU0x9ykg0kfWlk/pQBasm5ya08VgREjOOKbvb1P507iP/9k=","display_url":"https://scontent-mxp1-1.cdninstagram.com/vp/45552ea053442f3ed2cc04ce70a3030f/5BD6B6D0/t51.2885-15/e35/36113472_1835446843180291_3453440790187999232_n.jpg","display_resources":[{"src":"https://scontent-mxp1-1.cdninstagram.com/vp/339bf40607e214f8c29ce991e31923ce/5BE86C6A/t51.2885-15/sh0.08/e35/s640x640/36113472_1835446843180291_3453440790187999232_n.jpg","config_width":640,"config_height":640},{"src":"https://scontent-mxp1-1.cdninstagram.com/vp/b22e3dee80e7407605b29667d6cc841e/5BD3EFAE/t51.2885-15/sh0.08/e35/s750x750/36113472_1835446843180291_3453440790187999232_n.jpg","config_width":750,"config_height":750},{"src":"https://scontent-mxp1-1.cdninstagram.com/vp/45552ea053442f3ed2cc04ce70a3030f/5BD6B6D0/t51.2885-15/e35/36113472_1835446843180291_3453440790187999232_n.jpg","config_width":1080,"config_height":1080}],"is_video":false,"should_log_client_event":false,"tracking_token":"eyJ2ZXJzaW9uIjo1LCJwYXlsb2FkIjp7ImlzX2FuYWx5dGljc190cmFja2VkIjpmYWxzZSwidXVpZCI6IjgzMTNjYmU2ZDlmOTQ5YmFhZGM1M2E0MzJhMTlkNTJlMTgxMzIzNTE5MDkwMzE3MzE3OSIsInNlcnZlcl90b2tlbiI6IjE1MzEyMjE3MjUzODB8MTgxMzIzNTE5MDkwMzE3MzE3OXw2OTA5OHwxMzc1NThhODU1NjZlOTIxYjVmZWIyM2RhNjc1ZTgwMjkzMWI2ZjIxMWVlYjRjNzk4MGVlZmI5MmZlNDg1Zjg3In0sInNpZ25hdHVyZSI6IiJ9","edge_media_to_tagged_user":{"edges":[]}}},{"node":{"__typename":"GraphImage","id":"1813235203276353065","shortcode":"Bkp5895hS4p","dimensions":{"height":1080,"width":1080},"gating_info":null,"media_preview":"ACoqzbNVBDP0HXP+H+c1oheQV6c4I/Ssq1YA8/nWzCjbiVyOBj/9RpDKsiksQex6DjHrQCSmMD5jjPfH0/r71cEa87uT1XPf1+p9qRtyqe2Oee3vSAptEqKHP8Xb0/z+lL5n+yPypjZXv1IznofpU+QOw/76oAx7aYQuGPI/zzXR2z+aAVrlKsQXDw/dJAPUA1Qjd2qSSeuSRnr+H/1qeN/lAHPPPI6kc4zVWC/j2/N94dM+nt7+tLJfAqQD2/yakokaNVUMvU9T6H0A7f5NR+efb8qznujk7T16+9Q/aG9BTJK9FFFMAooooAKKKWgD/9k=","display_url":"https://scontent-mxp1-1.cdninstagram.com/vp/83e4e58be2c9d497a207c28f76b16505/5BD24E05/t51.2885-15/e35/35278952_244351252820597_6395226090658332672_n.jpg","display_resources":[{"src":"https://scontent-mxp1-1.cdninstagram.com/vp/94645e9abcb3f292d930a77148650680/5BD21AE0/t51.2885-15/sh0.08/e35/s640x640/35278952_244351252820597_6395226090658332672_n.jpg","config_width":640,"config_height":640},{"src":"https://scontent-mxp1-1.cdninstagram.com/vp/0165d6632f676d396c7063f5de6534a7/5BCD2EE0/t51.2885-15/sh0.08/e35/s750x750/35278952_244351252820597_6395226090658332672_n.jpg","config_width":750,"config_height":750},{"src":"https://scontent-mxp1-1.cdninstagram.com/vp/83e4e58be2c9d497a207c28f76b16505/5BD24E05/t51.2885-15/e35/35278952_244351252820597_6395226090658332672_n.jpg","config_width":1080,"config_height":1080}],"is_video":false,"should_log_client_event":false,"tracking_token":"eyJ2ZXJzaW9uIjo1LCJwYXlsb2FkIjp7ImlzX2FuYWx5dGljc190cmFja2VkIjpmYWxzZSwidXVpZCI6IjgzMTNjYmU2ZDlmOTQ5YmFhZGM1M2E0MzJhMTlkNTJlMTgxMzIzNTIwMzI3NjM1MzA2NSIsInNlcnZlcl90b2tlbiI6IjE1MzEyMjE3MjUzODR8MTgxMzIzNTIwMzI3NjM1MzA2NXw2OTA5OHwyYTE0NjU0OTJlMGM0MWNjNDFkZjEyOTljNjRlYmNjOGFhNzdiYzE5NDE1NzQ3N2E3ZWE3OGQ3ZjVjMzI4ZmQ0In0sInNpZ25hdHVyZSI6IiJ9","edge_media_to_tagged_user":{"edges":[]}}},{"node":{"__typename":"GraphImage","id":"1813235214928135993","shortcode":"Bkp59IwBUc5","dimensions":{"height":1080,"width":1080},"gating_info":null,"media_preview":"ACoqySUOMKwB6du/b2p8cTfMqnLD06kex7GnorblVgNq4+YdwvPHoTwDVyL94dydP8/59KQGb5asFIOXYjPOScnn6YxzmrLRBHOeQe3/ANb1p0pKEOyYdu/b/wDX2z1pwcR/uwDI/wCQHfGT6dqNx2sUmAyCGynv146ZHf6+lJ5jHtQwEgLBdpXHAz+vvUgPsfzoENIDLlSQBgEH3q0zEOqlisZ6Fflzgevr/nFRRMu35gMueB9Bj9ferLMSoRl3qf8AP4HtxQMWCPcjgNkbgAx9ue5pZVDYZW2yYxk9G9j6EevaoElGMcoqH6k57GknmVgG2fL2JP4dB0/GgBgfYpU/Mzklj1x2Gaf5Z9f5VAE2lkXIz0NRcDqpz34oExUypJ6kdv6j6U9pWZdxY7j2B98YwOlKnD8etREYkP1oAu8Bju+6w5H+e9VnyMLuzGD9OnOD3/GlU55+v8xVV6ALRkLksOKh81/WjqQO2KgNMD//2Q==","display_url":"https://scontent-mxp1-1.cdninstagram.com/vp/fda71289795bd83abf6f4d3f8ec51844/5BC69DF2/t51.2885-15/e35/36147967_362718267589296_8121448192236584960_n.jpg","display_resources":[{"src":"https://scontent-mxp1-1.cdninstagram.com/vp/efcb5dd532b88881f7b6af027daa9db6/5BDD1917/t51.2885-15/sh0.08/e35/s640x640/36147967_362718267589296_8121448192236584960_n.jpg","config_width":640,"config_height":640},{"src":"https://scontent-mxp1-1.cdninstagram.com/vp/03b136cc068a7e38fb0abc463e5eb07a/5BD8AD17/t51.2885-15/sh0.08/e35/s750x750/36147967_362718267589296_8121448192236584960_n.jpg","config_width":750,"config_height":750},{"src":"https://scontent-mxp1-1.cdninstagram.com/vp/fda71289795bd83abf6f4d3f8ec51844/5BC69DF2/t51.2885-15/e35/36147967_362718267589296_8121448192236584960_n.jpg","config_width":1080,"config_height":1080}],"is_video":false,"should_log_client_event":false,"tracking_token":"eyJ2ZXJzaW9uIjo1LCJwYXlsb2FkIjp7ImlzX2FuYWx5dGljc190cmFja2VkIjpmYWxzZSwidXVpZCI6IjgzMTNjYmU2ZDlmOTQ5YmFhZGM1M2E0MzJhMTlkNTJlMTgxMzIzNTIxNDkyODEzNTk5MyIsInNlcnZlcl90b2tlbiI6IjE1MzEyMjE3MjUzODd8MTgxMzIzNTIxNDkyODEzNTk5M3w2OTA5OHxlMzRkYTYxMDVkM2M2NTk2NmI2NTQ2MTQ3YWY1ZDY3YTU5ZGYzNzA3OTFlYzc2NmMxNDJjNTk1MDVjZTY3MmE1In0sInNpZ25hdHVyZSI6IiJ9","edge_media_to_tagged_user":{"edges":[]}}}]}}}}]},"gatekeepers":{"cb":true,"ld":true,"vl":true,"seo":true,"seoht":true,"2fac":true,"sf":true,"saa":true},"knobs":{"acct:ntb":0,"cb":0,"captcha":0},"qe":{"dash_for_vod":{"g":"","p":{}},"profile_header_name":{"g":"","p":{}},"aysf":{"g":"","p":{}},"bc3l":{"g":"","p":{}},"direct_conversation_reporting":{"g":"","p":{}},"general_reporting":{"g":"","p":{}},"reporting":{"g":"","p":{}},"acc_recovery_link":{"g":"","p":{}},"notif":{"g":"","p":{}},"fb_unlink":{"g":"","p":{}},"mobile_stories_doodling":{"g":"","p":{}},"move_comment_input_to_top":{"g":"","p":{}},"mobile_cancel":{"g":"","p":{}},"mobile_search_redesign":{"g":"","p":{}},"show_copy_link":{"g":"","p":{}},"mobile_logout":{"g":"","p":{}},"p_edit":{"g":"","p":{}},"404_as_react":{"g":"","p":{}},"acc_recovery":{"g":"control_with_cta_to_signup_02_22_18","p":{"has_cta_to_signup":"false"}},"collections":{"g":"","p":{}},"comment_ta":{"g":"","p":{}},"connections":{"g":"control","p":{"hide_profile_context":"false"}},"disc_ppl":{"g":"","p":{}},"ebdsim_li":{"g":"","p":{}},"ebdsim_lo":{"g":"","p":{}},"empty_feed":{"g":"","p":{}},"bundles":{"g":"","p":{}},"exit_story_creation":{"g":"","p":{}},"gdpr_logged_out":{"g":"","p":{}},"appsell":{"g":"","p":{}},"imgopt":{"g":"","p":{}},"follow_button":{"g":"test","p":{"is_inline":"true"}},"loggedout":{"g":"","p":{}},"loggedout_upsell":{"g":"control_without_new_loggedout_upsell_content_03_15_18","p":{"has_new_loggedout_upsell_content":"false"}},"us_li":{"g":"","p":{}},"msisdn":{"g":"","p":{}},"bg_sync":{"g":"","p":{}},"onetaplogin":{"g":"","p":{}},"login_poe":{"g":"","p":{}},"private_lo":{"g":"","p":{}},"profile_photo_nux_fbc_v2":{"g":"test_prefill_photo_and_skip_nux","p":{"prefill_photo":"true","skip_nux":"true"}},"profile_tabs":{"g":"","p":{}},"push_notifications":{"g":"","p":{}},"reg":{"g":"","p":{}},"reg_vp":{"g":"","p":{}},"feed_vp":{"g":"launch","p":{"is_hidden":"true"}},"report_haf":{"g":"","p":{}},"report_media":{"g":"","p":{}},"report_profile":{"g":"test","p":{"is_enabled":"true"}},"save":{"g":"control","p":{"is_enabled":"false"}},"sidecar_swipe":{"g":"","p":{}},"su_universe":{"g":"","p":{}},"stale":{"g":"","p":{}},"stories_lo":{"g":"test_05_01","p":{"hashtag":"true"}},"stories":{"g":"","p":{}},"tp_pblshr":{"g":"","p":{}},"video":{"g":"","p":{}},"gdpr_settings":{"g":"","p":{}},"gdpr_eu_tos":{"g":"age_two_button_05_01","p":{"gdpr_required":"true","eu_new_user_flow":"age_two_button","tos_version":"eu"}},"gdpr_row_tos":{"g":"","p":{}},"fd_gr":{"g":"","p":{}},"felix":{"g":"test","p":{"is_enabled":"true"}},"felix_clear_fb_cookie":{"g":"control","p":{"is_enabled":"true","blacklist":"fbsr_124024574287414"}},"felix_creation_duration_limits":{"g":"dogfooding","p":{"minimum_length_seconds":"15","maximum_length_seconds":"600"}},"felix_creation_enabled":{"g":"control","p":{"is_enabled":"true"}},"felix_creation_fb_crossposting":{"g":"control","p":{"is_enabled":"false"}},"felix_creation_fb_crossposting_v2":{"g":"control","p":{"is_enabled":"true"}},"felix_creation_validation":{"g":"control","p":{"edit_video_controls":"true","max_video_size_in_bytes":"3600000000","title_maximum_length":"75","description_maximum_length":"2200","valid_cover_mime_types":"image/jpeg,image/png","valid_video_mime_types":"video/mp4,video/quicktime","valid_video_extensions":"mp4,mov"}},"felix_creation_video_upload":{"g":"","p":{}},"felix_early_onboarding":{"g":"","p":{}},"pride":{"g":"test","p":{"enabled":"true","hashtag_whitelist":"lgbt,lesbian,gay,bisexual,transgender,trans,queer,lgbtq,girlslikeus,girlswholikegirls,instagay,pride,gaypride,loveislove,pansexual,lovewins,transequalitynow,lesbiansofinstagram,asexual,nonbinary,lgbtpride,lgbta,lgbti,queerfashion,queers,queerpride,queerlife,marriageequality,pride2018,genderqueer,bi,genderfluid,lgbtqqia,comingout,intersex,transman,transwoman,twospirit,transvisibility,queerart,dragqueen,dragking,dragartist,twomoms,twodads,lesbianmoms,gaydads,gendernonconforming"}},"unfollow_confirm":{"g":"test","p":{"no_feed_unfollow":"true"}},"profile_enhance_li":{"g":"","p":{}},"profile_enhance_lo":{"g":"","p":{}},"create_tag":{"g":"","p":{}},"phone_confirm":{"g":"","p":{}}},"hostname":"www.instagram.com","platform":"web","rhx_gis":"4ec99f1b7456a8e12345cbcb00e735ff","nonce":"HDlV5rZjhrIWtaH//srqYw==","zero_data":{},"rollout_hash":"db5f166b6f7a","bundle_variant":"base","probably_has_app":true,"show_app_install":false};</script>
    <script type="text/javascript">
    window.__initialDataLoaded(window._sharedData);
    </script>
            <script type="text/javascript">!function(e){var a=window.webpackJsonp;window.webpackJsonp=function(n,r,i){for(var c,d,f,g=0,s=[];g<n.length;g++)d=n[g],o[d]&&s.push(o[d][0]),o[d]=0;for(c in r)Object.prototype.hasOwnProperty.call(r,c)&&(e[c]=r[c]);for(a&&a(n,r,i);s.length;)s.shift()();if(i)for(g=0;g<i.length;g++)f=t(t.s=i[g]);return f};var n={},o={72:0};function t(a){if(n[a])return n[a].exports;var o=n[a]={i:a,l:!1,exports:{}};return e[a].call(o.exports,o,o.exports,t),o.l=!0,o.exports}t.e=function(e){var a=o[e];if(0===a)return new Promise(function(e){e()});if(a)return a[2];var n=new Promise(function(n,t){a=o[e]=[n,t]});a[2]=n;var r=document.getElementsByTagName("head")[0],i=document.createElement("script");i.type="text/javascript",i.charset="utf-8",i.async=!0,i.timeout=12e4,i.crossOrigin="anonymous",t.nc&&i.setAttribute("nonce",t.nc),i.src=t.p+""+({0:"SettingsModules",1:"MobileStoriesPage",2:"DesktopStoriesPage",3:"CreationModules",4:"ProfilePageContainer",5:"LikedByListContainer",6:"FollowListContainer",7:"LocationPageContainer",8:"DiscoverMediaPageContainer",9:"DiscoverEmbedsPageContainer",10:"TagPageContainer",11:"UserCollectionMediaPageContainer",12:"DebugInfoNub",13:"FeedPageContainer",14:"PostPageContainer",15:"LandingPage",16:"LoginAndSignupPage",17:"ResetPasswordPageContainer",18:"FBSignupPage",19:"IGTVVideoUploadPageContainer",20:"IGTVVideoDraftsPageContainer",21:"DiscoverPeoplePageContainer",22:"MultiStepSignupPage",23:"TermsUnblockPage",24:"DataDownloadRequestPage",25:"DirectInboxPageContainer",26:"AccessToolViewAllPage",27:"AccessToolPage",28:"NewUserInterstitial",29:"DataDownloadRequestConfirmPage",30:"ContactHistoryPage",31:"UserCollectionsPageContainer",32:"AccountRecoveryLandingPage",33:"DataControlsSupportPage",34:"LocationsDirectoryLandingPage",35:"LocationsDirectoryCountryPage",36:"LocationsDirectoryCityPage",37:"EmailConfirmationPage",38:"PhoneConfirmPage",39:"OneTapUpsell",40:"NewTermsConfirmPage",41:"CheckpointUnderageAppealPage",42:"TermsAcceptPage",43:"SuggestedDirectoryLandingPage",44:"ProfilesDirectoryLandingPage",45:"HashtagsDirectoryLandingPage",46:"OAuthPermissionsPage",47:"MobileStoriesLoginPage",48:"ActivityFeedPage",49:"HttpErrorPage",50:"DesktopStoriesLoginPage",51:"ParentalConsentPage",52:"ParentalConsentNotParentPage",53:"AndroidBetaPrivacyBugPage",54:"AccountPrivacyBugPage",55:"StoryCreationPage",56:"ContactInvitesOptOutPage",57:"ContactInvitesOptOutStatusPage",58:"Docpen",59:"Report",60:"Copyright",61:"Challenge",62:"SupportInfo",63:"Verification",64:"Community",65:"RapidReport",66:"Consumer",67:"EmailSnoozePage",68:"EmailUnsubscribePage",69:"NotificationLandingPage"}[e]||e)+".js/"+{0:"8cb0110cb342",1:"6ec1c009cb65",2:"338bda6c704f",3:"1ac03894a028",4:"ab860eb67f7d",5:"508570f2eb2d",6:"62325c01d9b8",7:"6b8a7b8d3b1d",8:"74b03122c655",9:"cc3a992ee603",10:"7c6471fef81c",11:"5be2851ca661",12:"924b979de544",13:"a94a5e935327",14:"8301b5645648",15:"9eb8ba46ce47",16:"2850e10b12e5",17:"f182abad10f2",18:"b8e0b747eef8",19:"44e232727be4",20:"ec39b98deed4",21:"bf1946bee6cc",22:"e6c3e3f9de94",23:"33775fd48f6f",24:"cb697a4832da",25:"fd75b901e31e",26:"88b646252fe5",27:"610d3ae597e8",28:"8ca0b5c9ad6f",29:"fbe9801114e3",30:"8d9d62ea70ad",31:"c76be4b7f340",32:"b30a1c6fa3c6",33:"5ec21e91144b",34:"7a6d2e0af733",35:"3e7dfafabfb2",36:"a0104e40a535",37:"4779dd2f2630",38:"8b381dc8deac",39:"8e8c19867ed1",40:"10ae028d2fbd",41:"4779318c2ffc",42:"71b6eb310af2",43:"ab8f6c78da02",44:"3dd66c8f8455",45:"40fc678ddbfd",46:"62bed7c79d44",47:"994effe0a340",48:"7c9152dd9f1f",49:"e74a31d06306",50:"7d365535635d",51:"7b34edc61863",52:"8664712384d7",53:"b6a7b233c735",54:"64a78b5ce9c1",55:"5e96140f587c",56:"f2a5c5651382",57:"42f691ee7a2c",58:"22b8bf6273c6",59:"7855f429f200",60:"853dac2caf1d",61:"9f3e656ff067",62:"cd6d6064b586",63:"be89707fbc3d",64:"f54c8b35ea28",65:"bc55fef13fec",66:"bf1f86b97707",67:"c443f41d61d0",68:"881cd292ca45",69:"dfe14f214984"}[e]+".js";var c=setTimeout(d,12e4);function d(){i.onerror=i.onload=null,clearTimeout(c);var a=o[e];0!==a&&(a&&a[1](new Error("Loading chunk "+e+" failed.")),o[e]=void 0)}return i.onerror=i.onload=d,r.appendChild(i),n},t.m=e,t.c=n,t.d=function(e,a,n){t.o(e,a)||Object.defineProperty(e,a,{configurable:!1,enumerable:!0,get:n})},t.n=function(e){var a=e&&e.__esModule?function(){return e.default}:function(){return e};return t.d(a,"a",a),a},t.o=function(e,a){return Object.prototype.hasOwnProperty.call(e,a)},t.p="/static/bundles/base/",t.oe=function(e){throw console.error(e),e}}([]);</script>

            <script type="text/javascript" src="/static/bundles/base/Vendor.js/4f7146874e51.js" crossorigin="anonymous"></script>
            <script type="text/javascript" src="/static/bundles/base/PostPageContainer.js/8301b5645648.js" crossorigin="anonymous" charset="utf-8" async=""></script>
<script type="text/javascript" src="/static/bundles/base/it_IT.js/fe9ac07ab2f4.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="/static/bundles/base/ConsumerCommons.js/6e98b50a53ce.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="/static/bundles/base/Consumer.js/bf1f86b97707.js" crossorigin="anonymous"></script>


<script>
!function(f,b,e,v,n,t,s){if(f.fbq)return;n=f.fbq=function(){n.callMethod?
n.callMethod.apply(n,arguments):n.queue.push(arguments)};if(!f._fbq)f._fbq=n;
n.push=n;n.loaded=!0;n.version='2.0';n.queue=[];t=b.createElement(e);t.async=!0;
t.src=v;s=b.getElementsByTagName(e)[0];s.parentNode.insertBefore(t,s)}(window,
document,'script','//connect.facebook.net/en_US/fbevents.js');

fbq('init', '1425767024389221');

fbq('track', 'PageView');


</script>
<noscript>


</noscript>



    </body>
</html>

        """