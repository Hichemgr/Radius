<?php

namespace SlimBundle\Controller;

use Proxies\__CG__\SlimBundle\Entity\Catalogue;
use SlimBundle\Entity\Assisstance;
use SlimBundle\Entity\Assisstant;
use SlimBundle\Entity\Conseil;
use SlimBundle\Entity\Produit;
use SlimBundle\Form\AssisstanceType;
use SlimBundle\Form\AssisstantType;
use SlimBundle\Form\CatalogueType;
use SlimBundle\Form\ProduitType;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
use AppBundle\Form\FormValidationType;
use Symfony\Component\HttpFoundation\File\UploadedFile;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;


class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('@Slim/Default/index.html.twig');
    }
    public function indexfrontAction()
    {
        return $this->render('@Slim/Default/indexfront.html.twig');
    }
    public function singlepostAction()
    {
        return $this->render('@Slim/Front/single-post.html.twig');
    }
    public function shopAction(Request $request )
    {
        $em = $this->getDoctrine()->getManager();
        $active = $em->getRepository("SlimBundle:Produit")->findAll();

        $Produit = $this->get('knp_paginator')
            ->paginate($active, $request->query->get('page', 1), 2);
        return $this->render('@Slim/Front/shop.html.twig', array('Produit' => $Produit,));
        //$proj = $this->getDoctrine()->getRepository(Produit::class)->findAll();

        //return $this->render('@Slim/Front/shop.html.twig', array('Produit'=>$proj));

    }

    public function shopdetailsAction($idproduit)
    {
        $proj = $this->getDoctrine()->getRepository(Produit::class)->find($idproduit);

        return $this->render('@Slim/Front/shopdetails.html.twig', array('Produit'=>$proj));

    }



    public function ajoutAssisstanceAction(Request $request)
    {
        $Assisstance = new Assisstance();

        $form = $this->createForm(AssisstanceType::class, $Assisstance);
        $form->handleRequest($request);
        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($Assisstance);
            $em->flush();
            return $this->redirectToRoute("ajoutAssisstance");
        }
        return $this->render("@Slim/Back/ajouterAssisstance.html.twig",
            array('Assisstance_form' => $form->createView()));
    }
    public function ajouterAssisstantAction(Request $request)
    {
        $Assisstant = new Assisstant();

        $form = $this->createForm(AssisstantType::class, $Assisstant);
        $form->handleRequest($request);
        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($Assisstant);
            $em->flush();
            return $this->redirectToRoute("afficherAssisstant");
        }
        return $this->render("@Slim/Back/ajouterAssisstant.html.twig",
            array('Assisstant_form' => $form->createView()));
    }
    public function afficherAssisstantAction()
    {
        $proj = $this->getDoctrine()->getRepository(Assisstant::class)->findAll();
        $proj1 = $this->getDoctrine()->getRepository(Assisstance::class)->findAll();
        $proj2 = $this->getDoctrine()->getRepository(Conseil::class)->findAll();
        return $this->render("@Slim/Back/afficherAssisstant.html.twig", array('Assisstant'=>$proj,'Assisstance'=>$proj1,'Conseil'=>$proj2));
    }
    public function supprimerAssisstantAction($IdAssisstant)
    {
        $em = $this->getDoctrine()->getManager();
        $post = $em->getRepository(Assisstant::class)->find($IdAssisstant);
        $em->remove($post);
        $em->flush();
        return $this->redirectToRoute("afficherAssisstant");
    }
    public function supprimerAssisstanceAction($idAssisstance)
    {
        $em = $this->getDoctrine()->getManager();
        $post = $em->getRepository(Assisstance::class)->find($idAssisstance);
        $em->remove($post);
        $em->flush();
        return $this->redirectToRoute("afficherAssisstant");
    }
    public function supprimerConseilAction($idConseil)
    {
        $em = $this->getDoctrine()->getManager();
        $post = $em->getRepository(Conseil::class)->find($idConseil);
        $em->remove($post);
        $em->flush();
        return $this->redirectToRoute("afficherAssisstant");
    }

    public function modifierAssisstantAction($IdAssisstant,Request $request){
        $cars=$this->getDoctrine()->getRepository(Assisstant::class)->find($IdAssisstant);
        $form=$this->createForm(AssisstantType::class,$cars);
        $form->handleRequest($request);
        if ($form->isValid()){
            $e = $this->getDoctrine()->getManager();
            $e->flush();
            return $this->redirectToRoute("afficherAssisstant");
        }
        return $this->render("@Slim/Back/modifierAssisstant.html.twig",array("form_modifier"=>$form->createView()));
    }
    public function modifierAssisstanceAction($idAssisstance,Request $request){
        $cars=$this->getDoctrine()->getRepository(Assisstance::class)->find($idAssisstance);
        $form=$this->createForm(AssisstanceType::class,$cars);
        $form->handleRequest($request);
        if ($form->isValid()){
            $e = $this->getDoctrine()->getManager();
            $e->flush();
            return $this->redirectToRoute("afficherAssisstant");
        }
        return $this->render("@Slim/Back/modifierAssisstance.html.twig",array("form_modifier"=>$form->createView()));
    }
    public function afficherProduitAction()
    {
        $proj = $this->getDoctrine()->getRepository(Produit::class)->findAll();

        return $this->render("@Slim/Back/afficherProduit.html.twig", array('Produit'=>$proj));
    }

    public function modifierProduitAction(Request $request){


            $idproduit = $request->get('idproduit');
            $em = $this->getDoctrine()->getManager();
            $produit = $em->getRepository("SlimBundle:Produit")
                ->find($idproduit);

            $form = $this->createForm(ProduitType::class, $produit);
            $form->handleRequest($request);

            if ($form->isValid() && ($form->isValid())) {
                $file = $produit->getImagep();
                $fileName = $this->generateUniqueFileName() . '.' . $file->guessExtension();
                $file->move($this->getParameter('image_directory'), $fileName);
                $produit->setImagep($fileName);

                $em->persist($produit);
                $em->flush();
                return $this->redirectToRoute('afficherProduit');
            }
            return $this->render("@Slim/Back/modifierProduit.html.twig"
                , array("form_ajouter" => $form->createView()));

        /**$cars=$this->getDoctrine()->getRepository(Produit::class)->find($nomproduit);
        $form=$this->createForm(ProduitType::class,$cars);
        $form->handleRequest($request);
        if ($form->isValid()){
            $e = $this->getDoctrine()->getManager();
            $e->flush();
            return $this->redirectToRoute("afficherProduit");
        }
        return $this->render("@Slim/Back/modifierProduit.html.twig",array("form_modifier"=>$form->createView()));**/
    }
    public function supprimerProduitAction($idproduit)
    {
        $em = $this->getDoctrine()->getManager();
        $post = $em->getRepository(Produit::class)->find($idproduit);
        $em->remove($post);
        $em->flush();
        return $this->redirectToRoute("afficherProduit");
    }
    public function ajouterProduitAction(Request $request)
    {
        $Produit = new Produit();
        $form = $this->createForm(\SlimBundle\Form\ProduitType::class, $Produit);
        $form->handleRequest($request);
        if ($form->isSubmitted()&&$form->isValid()) {
            /**
             * @var UploadedFile $file
             */
            $file = $Produit->getImagep();
            $fileName = md5(uniqid()) . '.' . $file->guessExtension();
            $file->move(
                $this->getParameter('image_directory'), $fileName);
            $Produit->setImagep($fileName);

            $em = $this->getDoctrine()->getManager();
            $em->persist($Produit);
            $em->flush();
            return $this->redirectToRoute("afficherProduit");
        }
        return $this->render('@Slim/Back/ajouterProduit.html.twig',array(
            "form_ajouter"=>$form->createView()
        ));
    }
    private function generateUniqueFileName()
    {

        return md5(uniqid());
    }

    public function searchAjaxAction($title)

    {

        $em = $this->getDoctrine()->getManager();

        $article = $em->getRepository("SlimBundle:Produit")->FindByLetters($title);
        return $this->render("@Slim/Back/LesProduits.html.twig",
            array('Produit' => $article,
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
