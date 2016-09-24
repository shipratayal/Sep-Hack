// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require theme/jquery-3.1.0.min.js
//= require theme/jquery-migrate-1.4.1.min.js
//= require theme/bootstrap.min.js
//= require theme/jquery.icheck.min.js
//= require theme/custom.min.js
//= require theme/core.min.js
//= require theme/pages/login.js
//= require_self

if (typeof jQuery !== 'undefined') {
    (function ($) {
        $('#spinner').ajaxStart(function () {
            $(this).fadeIn();
        }).ajaxStop(function () {
            $(this).fadeOut();
        });
    })(jQuery);
}