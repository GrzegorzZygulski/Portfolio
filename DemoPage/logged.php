<html>
<!DOCTYPE html>
<html>

<style>
body {
  background-color: linen;
}
input{
  width:20%;
}
</style>

<body>

<?php if ($_POST["login"]!="grzegorz.zygulski@gmail.com") { ?>
<h1 id="isFailture" > "Access_denied"  </h1>

account <?php echo $_POST["login"]; ?> does not exist!
<?php } else {?>
<h1 id="isFailture" > 
logged as <?php echo $_POST["login"]; ?>!</h1>



<?php }?>

</body>
</html> 