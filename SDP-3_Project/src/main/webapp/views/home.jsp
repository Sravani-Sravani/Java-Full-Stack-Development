<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Landing page</title>
    <style>
    
    </style>
    <style>
    @import url('https://fonts.googleapis.com/css2?family=Lato:ital,wght@0,300;0,400;0,700;0,900;1,300;1,400;1,700;1,900&display=swap');
*{
    box-sizing: border-box;
    margin: 0;
    padding: 0;
}
body{
    font-family: 'Lato', sans-serif;
    height: 100vh;
    width: 100%;
    background-image: url(@{/SDP-3_Project/src/main/webapp/views/background.jpg});
    background-size: cover;
    background-position: center;
    color: #fff;
    overflow: hidden;
}
.glass_view{
    margin: 3rem;
    padding: 1.8rem;
    background-color: rgba(255,255,255, 0.2);
    height: 90%;
    text-transform: capitalize;
    border-radius: 1rem;
    backdrop-filter: blur(10px);
}
.header{
    display: flex;
    justify-content: space-between;
    align-items: center;
}
nav a{
    color: #fff;
    text-decoration: none;
    margin-left: 1rem;
    font-size: 1.25rem;
}
nav a:hover{
    text-decoration: underline;
}
.container{
    display: flex;
    justify-content: space-between;
    align-items: center;
    height: 100%;
    margin: 0 2rem;
}
.content{
    flex-basis: 40%;
}
.content h2{
    font-size: 2rem;
}
.content p{
    font-size: 1.25rem;
    line-height: 1.7;
    margin-bottom: 1.5rem;
}
.content a{
    padding: .6rem 1.8rem;
    background-color: #6c63ff;
    color: #fff;
    text-decoration: none;
    border-radius: 1.8rem;
    font-size: 1.25rem;
}
.image{
    flex-basis: 40%;
    min-width: 500px;
}
.image img{
    width: 100%;
    height: 100%;
}
</style>
</head>
<body>
    <div class="glass_view">
        <div class="header">
            <h1>AmazingUI</h1>
            <nav>
                <a href="#">home</a>
                <a href="#">about</a>
                <a href="#">contact</a>
            </nav>
        </div>
        <div class="container">
            <div class="content">
                <h2>beautiful design</h2>
                <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Doloribus dicta reprehenderit perferendis qui excepturi alias magni expedita nostrum ullam aspernatur.</p>
                <a href="#">explore &#8594;</a>
            </div>
            <div class="image">
                <img src="/SDP-3_Project/src/main/webapp/views/image.jpg">
            </div>
        </div>
    </div>
</body>
</html>