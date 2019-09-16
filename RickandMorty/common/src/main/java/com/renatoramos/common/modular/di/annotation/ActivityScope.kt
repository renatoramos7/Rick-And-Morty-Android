package com.renatoramos.common.modular.di.annotation

import javax.inject.Scope

/**
 * This meta-annotation determines whether an annotation is stored in binary output and visible for reflection. By default, both are true.
 *  Say you also want that certain dependencies during lifetime of said component where created only once.
 */

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope