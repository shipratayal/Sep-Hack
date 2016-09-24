<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<html>
<head>
    <meta charset="utf-8">
    <title>CKEditor</title>
    <script src="//cdn.ckeditor.com/4.5.11/standard/ckeditor.js"></script>
</head>
<body>
<g:form controller="test" action="saveText">
    <textarea name="editor1"></textarea>
    <g:submitButton name="Submit"></g:submitButton>
</g:form>
<script>
    CKEDITOR.replace( 'editor1' );
</script>
</body>
</html>