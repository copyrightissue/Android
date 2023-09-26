/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.data

import com.example.dogglers.R
import com.example.dogglers.model.Dog

/**
 * An object to generate a static list of dogs
 */
object DataSource {

    val dogs: List<Dog> = listOf(
        Dog(
            R.drawable.tzeitel,
            "Pasta Salad",
            "Salad Dressing: \n 1 egg \n 1/4 cup sour cream \n 2Tbsp dijon mustard \n 1 1/2 Tbsp sugar \n 1 Tbsp lemon juice \n 1 tsp worcestershire \n 1 tsp salt \n 1 clove garlic \n 1 1/3 cup canola oil",
            " Ingredients: \n .5 lbs Macaroni \n 2 Tbsp vinegar \n 1 Tbsp olive oil \n 1/2 cup celery \n 1/2 cup peas \n 1/2 pickled celery \n 1/4 lbs crumbled bacon \n 2 Tbsp dill \n 4 hard boiled eggs \n 1/4 cup cilantro"
        ),
        Dog(
            R.drawable.leroy,
            "Pizza",
            "Crust: \n 210g beer \n 350g flour \n 5g salt \n 8g sugar \n 7g yeast \n 15g olive oil",
            "Toppings: \n sauce \n cheese \n pepperoni \n artichoke hearts \n mushrooms \n basil leaves"
        ),
        Dog(
            R.drawable.frankie,
            "Katsu Curry",
            "Curry Ingredients: \n 1 block, japanese curry \n 1 stick butter \n 3 onions, julienned \n 1 apple, grated \n 1 Tbsp tomato paste \n 2 carrots \n 2 potatoes \n 2 Tbsp honey \n 2 Tbsp worcestershire \n 1 Tbsp soy sauce \n 2 cups chicken stock",
            "Katsu Ingredients: \n 1 chicken breast \n 1 egg \n 1 cup flour \n 1 cup panko \n 1/2 cup oil"
        ),
        Dog(
            R.drawable.nox,
            "Chicken Biryani",
            "Ingredients: \n 1/2 large onion \n 2 cloves garlic \n 1 inch piece ginger \n 5 cloves \n 10 peppercorns \n 4 cardamom pods \n 1/4 tsp cinnamon \n 1/2 tsp coriander \n 1/2 tsp cumin \n 1/2 tsp poppy seeds \n 12g salt \n 1/2 lemon juiced \n 4oz yogurt \n 1 lbs chicken thighs",
            "Rice: \n 60g vegetable oil \n 1/2 large onion \n 3 bay leaves \n 2 cardamom pods \n 1tsp saffron \n 30g milk \n 120g rice \n fried golden raisins \n 2 Tbsp almonds \n 2 hard-boiled eggs"
        ),
        Dog(
            R.drawable.faye,
            "Shepard's Pie",
            "Ingredients: \n 2Tbsp canola oil \n 1 cup chopped onion \n 2 carrots \n 2 cloves garlic \n 1.5 lbs ground meat \n 1 tsp salt \n 1/2 tsp pepper \n 2 Tbsp flour \n 2 Tbsp tomato paste \n 1 cup chicken stock \n 1 tsp worcestershire \n 1 tsp rosemary \n 1 tsp thyme \n 1 cup peas \n 1 cup corn ",
            "Mashed potatoes: \n 1.5 lbs russet potatoes \n 1/4 cup half and half \n 2 oz butter \n 1 tsp salt \n 1/2 tsp pepper \n 1 egg yolk"
        ),
        Dog(
            R.drawable.bella,
            "Smoked Brisket",
            "Dry Rub: \n 2Tbsp kosher salt \n 2 Tbsp pepper \n 1 Tbsp onion powder \n 1 Tbsp garlic powder \n 1 Tbsp smoked paprika \n 2 tsp coriander",
            "Ingredients: 1 trimmed brisket \n 1 cup beef stock \n 1 cup apple juice \n 1/2 cup apple cider vinegar"
        )
    )
}
