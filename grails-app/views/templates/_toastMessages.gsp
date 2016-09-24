<g:if test="${flash.success}">
    <script>
        toastr.success("${flash.success}")
    </script>
</g:if>
<g:if test="${flash.error}">
    <script>
        toastr.error("${flash.error}")
    </script>
</g:if>
<g:if test="${flash.warning}">
    <script>
        toastr.warning("${flash.warning}")
    </script>
</g:if>
<g:if test="${flash.info}">
    <script>
        toastr.info("${flash.info}")
    </script>
</g:if>
<g:if test="${flash.message}">
    <script>
        toastr.info("${flash.message}")
    </script>
</g:if>