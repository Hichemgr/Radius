<?php
/**
 * Created by PhpStorm.
 * User: raedm
 * Date: 16-Apr-19
 * Time: 11:17
 */

namespace SlimBundle\Controller;
use SlimBundle\Entity\Catalogue;
use SlimBundle\Form\CatalogueType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use AppBundle\Form\FormValidationType;
use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;
use Symfony\Component\HttpFoundation\JsonResponse;






class CatalogueController extends Controller
{
    public function afficherCatalogueAction()
    {
        $proj = $this->getDoctrine()->getRepository(Catalogue::class)->findAll();

        return $this->render("@Slim/Back/afficherCatalogue.html.twig", array('Catalogue' => $proj));
    }

    public function ajouterCatalogueAction(Request $request)
    {
        $Catalogue = new Catalogue();

        $form = $this->createForm(CatalogueType::class, $Catalogue);
        $form->handleRequest($request);
        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($Catalogue);
            $em->flush();
            return $this->redirectToRoute("afficherCatalogue");
        }
        return $this->render("@Slim/Back/ajouterCatalogue.html.twig",
            array('Catalogue_form' => $form->createView()));
    }

    public function supprimerCatalogueAction($idcatalogue)
    {
        $em = $this->getDoctrine()->getManager();
        $post = $em->getRepository(Catalogue::class)->find($idcatalogue);
        $em->remove($post);
        $em->flush();
        return $this->redirectToRoute("afficherCatalogue");
    }


        public function modifierCatalogueAction(Request $request)
        {


            $idcatalogue = $request->get('idcatalogue');
            $em = $this->getDoctrine()->getManager();
            $cat = $em->getRepository("SlimBundle:Catalogue")
                ->find($idcatalogue);

            $form = $this->createForm(CatalogueType::class, $cat);
            $form->handleRequest($request);

            if ($form->isValid() && ($form->isValid())) {

                $em->persist($cat);
                $em->flush();
                return $this->redirectToRoute('afficherCatalogue');
            }
            return $this->render("@Slim/Back/modifierCatalogue.html.twig"
                , array("Catalogue_form" => $form->createView()));
        }
    public function searchAjaxAction($title)

    {

        $em = $this->getDoctrine()->getManager();

        $article = $em->getRepository("SlimBundle:Catalogue")->FindByLetters($title);
        return $this->render("@Slim/Back/LesCatalogues.html.twig",
            array('Catalogue' => $article,
            ));

        $normalizer = new ObjectNormalizer();
        $normalizer->setCircularReferenceLimit(2);


        $normalizer->setCircularReferenceHandler(function ($article) {
            return $article->getId();
        });
        $s = new Serializer(array($normalizer));
        $articles = $s->normalize($article,'json');
        $response = new JsonResponse();
        return $response->setData(array('articles'=>$articles));
    }
}